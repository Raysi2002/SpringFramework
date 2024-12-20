~~package com.raysi.blogmanagementsystem.controllers;

import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {
@Autowired
private PostService postService;
//Getting all the post from the database
@GetMapping("/api/posts")
public List<Post> getAllPosts(){
return postService.getAllPost();
}

    @PostMapping("/api/posts")
    public String publishPost(@RequestBody Post post){
        postService.savePost(post);
        return "Post published successfully!";
    }
}


package com.raysi.blogmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  Long catId;
@Column(unique = true)
private String name;
@Lob
private String description;
@Version
private Long version;
}

package com.raysi.blogmanagementsystem.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long postId;
@Column(length = 500)
private String title;
@Lob
private String content;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(
name = "user_id",
referencedColumnName = "userId"
)
private User user;
//    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name = "post_tag",
//            joinColumns = @JoinColumn(
//                    name = "post_id",
//                    referencedColumnName = "postId"
//            ),
//            inverseJoinColumns = @JoinColumn(
//                    name = "tag_id",
//                    referencedColumnName = "tagId"
//            )
//    )
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "tag_id", referencedColumnName = "tagId")
private Tag tags;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(
name = "category_id",
referencedColumnName = "catId"
)
private Category category;
@CreationTimestamp
private LocalDateTime createdTime;
@UpdateTimestamp
private LocalDateTime updatedTime;
}


package com.raysi.blogmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tags")
public class Tag {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long tagId;
@Column(unique = true)
private String name;
@Version
private Long version;
}

package com.raysi.blogmanagementsystem.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId;
private String name;
@Column(unique = true)
private String email;
@Column(length = 1000)
private String bio;
@CreationTimestamp
private LocalDateTime createdTime;
@UpdateTimestamp
private LocalDateTime updatedTime;

}

package com.raysi.blogmanagementsystem.services;

import com.raysi.blogmanagementsystem.entities.Category;
import com.raysi.blogmanagementsystem.entities.Post;
import com.raysi.blogmanagementsystem.repositories.CategoryRepository;
import com.raysi.blogmanagementsystem.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;


    public List<Post> getAllPost(){
        return postRepository.findAll();
    }

    public void savePost(Post post){
        postRepository.save(post);
    }

}

----------sending this data from postman-------------
{
"title": "Ray's Journey Of Tech",
"content": "Even though I completed my diploma in Mechanical Engineering, I had zero knowledge about coding. But when I joined GIET, I was exposed to programming, and it fascinated me so much that now I can't think about anything except programming. #DSA #Java #JavaScript #HTML #CSS",
"tag": {"tagId": 1, "name": "Java"},
// {"tagId": 2, "name": "DSA"},
// {"tagId": 3, "name": "JavaScript"},
// {"tagId": 4, "name": "HTML"},
// {"tagId": 5, "name": "CSS"}

    "category": {
        "catId": 1,
        "name": "Personal Life",
        "desc": "Posts related to personal experiences and growth."
    }
}

---------errro--------------------
{
"timestamp": "2024-12-19T07:32:37.884+00:00",
"status": 500,
"error": "Internal Server Error",
"trace": "org.springframework.dao.DataIntegrityViolationException: Detached entity with generated id '1' has an uninitialized version value 'null': com.raysi.blogmanagementsystem.entities.Category.version\n\tat org.springframework.orm.jpa.vendor.HibernateJpaDialect.convertHibernateAccessException(HibernateJpaDialect.java:307)\n\tat org.springframework.orm.jpa.vendor.HibernateJpaDialect.translateExceptionIfPossible(HibernateJpaDialect.java:241)\n\tat org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.translateExceptionIfPossible(AbstractEntityManagerFactoryBean.java:560)\n\tat org.springframework.dao.support.ChainedPersistenceExceptionTranslator.translateExceptionIfPossible(ChainedPersistenceExceptionTranslator.java:61)\n\tat org.springframework.dao.support.DataAccessUtils.translateIfNecessary(DataAccessUtils.java:343)\n\tat org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:160)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.data.jpa.repository.support.CrudMethodMetadataPostProcessor$CrudMethodMetadataPopulatingMethodInterceptor.invoke(CrudMethodMetadataPostProcessor.java:165)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:223)\n\tat jdk.proxy4/jdk.proxy4.$Proxy127.save(Unknown Source)\n\tat com.raysi.blogmanagementsystem.services.PostService.savePost(PostService.java:24)\n\tat com.raysi.blogmanagementsystem.controllers.PostController.publishPost(PostController.java:25)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:255)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:188)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:986)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:891)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1088)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:978)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)\n\tat org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:590)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)\n\tat jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1741)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190)\n\tat org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63)\n\tat java.base/java.lang.Thread.run(Thread.java:1570)\nCaused by: org.hibernate.PropertyValueException: Detached entity with generated id '1' has an uninitialized version value 'null': com.raysi.blogmanagementsystem.entities.Category.version\n\tat org.hibernate.persister.entity.AbstractEntityPersister.isTransient(AbstractEntityPersister.java:4298)\n\tat org.hibernate.engine.internal.ForeignKeys.isTransient(ForeignKeys.java:316)\n\tat org.hibernate.event.internal.EntityState.getEntityState(EntityState.java:64)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.entityState(DefaultPersistEventListener.java:114)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:87)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:79)\n\tat org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:138)\n\tat org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:803)\n\tat org.hibernate.internal.SessionImpl.persist(SessionImpl.java:751)\n\tat org.hibernate.engine.spi.CascadingActions$7.cascade(CascadingActions.java:295)\n\tat org.hibernate.engine.spi.CascadingActions$7.cascade(CascadingActions.java:285)\n\tat org.hibernate.engine.internal.Cascade.cascadeToOne(Cascade.java:570)\n\tat org.hibernate.engine.internal.Cascade.cascadeAssociation(Cascade.java:492)\n\tat org.hibernate.engine.internal.Cascade.cascadeProperty(Cascade.java:253)\n\tat org.hibernate.engine.internal.Cascade.cascade(Cascade.java:192)\n\tat org.hibernate.event.internal.AbstractSaveEventListener.cascadeBeforeSave(AbstractSaveEventListener.java:489)\n\tat org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:305)\n\tat org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:223)\n\tat org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:136)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.entityIsTransient(DefaultPersistEventListener.java:177)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.persist(DefaultPersistEventListener.java:95)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:79)\n\tat org.hibernate.event.internal.DefaultPersistEventListener.onPersist(DefaultPersistEventListener.java:55)\n\tat org.hibernate.event.service.internal.EventListenerGroupImpl.fireEventOnEachListener(EventListenerGroupImpl.java:127)\n\tat org.hibernate.internal.SessionImpl.firePersist(SessionImpl.java:761)\n\tat org.hibernate.internal.SessionImpl.persist(SessionImpl.java:745)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.orm.jpa.ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler.invoke(ExtendedEntityManagerCreator.java:364)\n\tat jdk.proxy4/jdk.proxy4.$Proxy122.persist(Unknown Source)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:320)\n\tat jdk.proxy4/jdk.proxy4.$Proxy122.persist(Unknown Source)\n\tat org.springframework.data.jpa.repository.support.SimpleJpaRepository.save(SimpleJpaRepository.java:623)\n\tat java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:580)\n\tat org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:359)\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker$RepositoryFragmentMethodInvoker.lambda$new$0(RepositoryMethodInvoker.java:277)\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker.doInvoke(RepositoryMethodInvoker.java:170)\n\tat org.springframework.data.repository.core.support.RepositoryMethodInvoker.invoke(RepositoryMethodInvoker.java:158)\n\tat org.springframework.data.repository.core.support.RepositoryComposition$RepositoryFragments.invoke(RepositoryComposition.java:515)\n\tat org.springframework.data.repository.core.support.RepositoryComposition.invoke(RepositoryComposition.java:284)\n\tat org.springframework.data.repository.core.support.RepositoryFactorySupport$ImplementationMethodExecutionInterceptor.invoke(RepositoryFactorySupport.java:752)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.doInvoke(QueryExecutorMethodInterceptor.java:174)\n\tat org.springframework.data.repository.core.support.QueryExecutorMethodInterceptor.invoke(QueryExecutorMethodInterceptor.java:149)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.data.projection.DefaultMethodInvokingMethodInterceptor.invoke(DefaultMethodInvokingMethodInterceptor.java:69)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:380)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)\n\tat org.springframework.dao.support.PersistenceExceptionTranslationInterceptor.invoke(PersistenceExceptionTranslationInterceptor.java:138)\n\t... 55 more\n",
"message": "Detached entity with generated id '1' has an uninitialized version value 'null': com.raysi.blogmanagementsystem.entities.Category.version",
"path": "/api/posts"
}~~