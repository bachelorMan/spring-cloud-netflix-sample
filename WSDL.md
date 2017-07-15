### Instruction

Refer to

* http://websystique.com/java/jaxb/jaxb-codegeneration-maven-example/
* https://github.com/highsource/maven-jaxb2-plugin/wiki/Specifying-What-To-Compile

Using _maven jaxb2 plugin_ to generate stub
```
fanhonglingdeMacBook-Pro:msa-sms fanhongling$ mvn org.jvnet.jaxb2.maven2:maven-jaxb2-plugin:generate
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building msa-sms 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-jaxb2-plugin:0.13.1:generate (default-cli) @ msa-sms ---
[INFO] Up-to-date check for source resources [[file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml, file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/pom.xml]] and target resources [[file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/target/generated-sources/xjc/META-INF/sun-jaxb.episode]].
[INFO] Latest timestamp of the source resources is [2017-07-14 07:39:14.000], earliest timestamp of the target resources is [2017-07-14 07:34:39.000].
[INFO] Sources are not up-to-date, XJC will be executed.
[INFO] Episode file [/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/target/generated-sources/xjc/META-INF/sun-jaxb.episode] was augmented with if-exists="true" attributes.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 3.204 s
[INFO] Finished at: 2017-07-14T07:39:23-07:00
[INFO] Final Memory: 22M/331M
[INFO] ------------------------------------------------------------------------
```

Trouble shooting _A class/interface with the same name "<packageName>.RemoteException" is already in use. Use a class customization to resolve this conflict._
```
fanhonglingdeMacBook-Pro:msa-sms fanhongling$ mvn org.jvnet.jaxb2.maven2:maven-jaxb2-plugin:generate
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building msa-sms 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-jaxb2-plugin:0.13.1:generate (default-cli) @ msa-sms ---
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb2-plugin-core/0.13.1/maven-jaxb2-plugin-core-0.13.1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb2-plugin-core/0.13.1/maven-jaxb2-plugin-core-0.13.1.pom (2 KB at 0.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/org/apache/xml/internal/resolver/20050927/resolver-20050927.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/org/apache/xml/internal/resolver/20050927/resolver-20050927.pom (183 B at 0.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/junit/junit/4.8.1/junit-4.8.1.pom
Downloaded: https://repo.maven.apache.org/maven2/junit/junit/4.8.1/junit-4.8.1.pom (949 B at 2.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb22-plugin/0.13.1/maven-jaxb22-plugin-0.13.1.pom
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb22-plugin/0.13.1/maven-jaxb22-plugin-0.13.1.pom (2 KB at 3.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-runtime/2.2.11/jaxb-runtime-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-runtime/2.2.11/jaxb-runtime-2.2.11.pom (4 KB at 1.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-runtime-parent/2.2.11/jaxb-runtime-parent-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-runtime-parent/2.2.11/jaxb-runtime-parent-2.2.11.pom (3 KB at 5.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-core/2.2.11/jaxb-core-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-core/2.2.11/jaxb-core-2.2.11.pom (4 KB at 5.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/javax/xml/bind/jaxb-api/2.2.12-b140109.1041/jaxb-api-2.2.12-b140109.1041.pom
Downloaded: https://repo.maven.apache.org/maven2/javax/xml/bind/jaxb-api/2.2.12-b140109.1041/jaxb-api-2.2.12-b140109.1041.pom (16 KB at 19.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/txw2/2.2.11/txw2-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/txw2/2.2.11/txw2-2.2.11.pom (4 KB at 6.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-txw-parent/2.2.11/jaxb-txw-parent-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-txw-parent/2.2.11/jaxb-txw-parent-2.2.11.pom (3 KB at 4.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-runtime/2.21/istack-commons-runtime-2.21.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-runtime/2.21/istack-commons-runtime-2.21.pom (4 KB at 7.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons/2.21/istack-commons-2.21.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons/2.21/istack-commons-2.21.pom (11 KB at 14.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/staxex/stax-ex/1.7.7/stax-ex-1.7.7.pom
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/staxex/stax-ex/1.7.7/stax-ex-1.7.7.pom (12 KB at 17.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/FastInfoset/1.2.13/FastInfoset-1.2.13.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/FastInfoset/1.2.13/FastInfoset-1.2.13.pom (5 KB at 8.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/fastinfoset-project/1.2.13/fastinfoset-project-1.2.13.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/fastinfoset-project/1.2.13/fastinfoset-project-1.2.13.pom (14 KB at 18.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-xjc/2.2.11/jaxb-xjc-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-xjc/2.2.11/jaxb-xjc-2.2.11.pom (9 KB at 13.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xsom/xsom/20140925/xsom-20140925.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xsom/xsom/20140925/xsom-20140925.pom (12 KB at 17.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/relaxngDatatype/relaxngDatatype/20020414/relaxngDatatype-20020414.pom
Downloaded: https://repo.maven.apache.org/maven2/relaxngDatatype/relaxngDatatype/20020414/relaxngDatatype-20020414.pom (167 B at 0.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/codemodel/2.2.11/codemodel-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/codemodel/2.2.11/codemodel-2.2.11.pom (3 KB at 5.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-codemodel-parent/2.2.11/jaxb-codemodel-parent-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-codemodel-parent/2.2.11/jaxb-codemodel-parent-2.2.11.pom (3 KB at 5.3 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/external/rngom/2.2.11/rngom-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/external/rngom/2.2.11/rngom-2.2.11.pom (4 KB at 7.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-external-parent/2.2.11/jaxb-external-parent-2.2.11.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/mvn/jaxb-external-parent/2.2.11/jaxb-external-parent-2.2.11.pom (3 KB at 3.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/dtd-parser/dtd-parser/1.1/dtd-parser-1.1.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/dtd-parser/dtd-parser/1.1/dtd-parser-1.1.pom (3 KB at 3.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-tools/2.21/istack-commons-tools-2.21.pom
Downloaded: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-tools/2.21/istack-commons-tools-2.21.pom (6 KB at 10.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.pom (10 KB at 15.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/ant/ant-parent/1.7.0/ant-parent-1.7.0.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/ant/ant-parent/1.7.0/ant-parent-1.7.0.pom (5 KB at 8.8 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/ant/ant-launcher/1.7.0/ant-launcher-1.7.0.pom
Downloaded: https://repo.maven.apache.org/maven2/org/apache/ant/ant-launcher/1.7.0/ant-launcher-1.7.0.pom (3 KB at 4.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb2-plugin-core/0.13.1/maven-jaxb2-plugin-core-0.13.1.jar
Downloading: https://repo.maven.apache.org/maven2/com/sun/org/apache/xml/internal/resolver/20050927/resolver-20050927.jar
Downloading: https://repo.maven.apache.org/maven2/junit/junit/4.8.1/junit-4.8.1.jar
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb22-plugin/0.13.1/maven-jaxb22-plugin-0.13.1.jar
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-runtime/2.2.11/jaxb-runtime-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb22-plugin/0.13.1/maven-jaxb22-plugin-0.13.1.jar (27 KB at 17.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-core/2.2.11/jaxb-core-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/com/sun/org/apache/xml/internal/resolver/20050927/resolver-20050927.jar (67 KB at 41.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/javax/xml/bind/jaxb-api/2.2.12-b140109.1041/jaxb-api-2.2.12-b140109.1041.jar
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/jaxb2/maven2/maven-jaxb2-plugin-core/0.13.1/maven-jaxb2-plugin-core-0.13.1.jar (66 KB at 32.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/txw2/2.2.11/txw2-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/junit/junit/4.8.1/junit-4.8.1.jar (232 KB at 105.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-runtime/2.21/istack-commons-runtime-2.21.jar
Downloaded: https://repo.maven.apache.org/maven2/javax/xml/bind/jaxb-api/2.2.12-b140109.1041/jaxb-api-2.2.12-b140109.1041.jar (100 KB at 39.6 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/jvnet/staxex/stax-ex/1.7.7/stax-ex-1.7.7.jar
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-core/2.2.11/jaxb-core-2.2.11.jar (150 KB at 59.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/FastInfoset/1.2.13/FastInfoset-1.2.13.jar
Downloaded: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-runtime/2.21/istack-commons-runtime-2.21.jar (23 KB at 6.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-xjc/2.2.11/jaxb-xjc-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/org/jvnet/staxex/stax-ex/1.7.7/stax-ex-1.7.7.jar (33 KB at 7.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xsom/xsom/20140925/xsom-20140925.jar
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/txw2/2.2.11/txw2-2.2.11.jar (68 KB at 11.2 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/relaxngDatatype/relaxngDatatype/20020414/relaxngDatatype-20020414.jar
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/fastinfoset/FastInfoset/1.2.13/FastInfoset-1.2.13.jar (290 KB at 41.0 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/codemodel/2.2.11/codemodel-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/relaxngDatatype/relaxngDatatype/20020414/relaxngDatatype-20020414.jar (19 KB at 2.5 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/bind/external/rngom/2.2.11/rngom-2.2.11.jar
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-xjc/2.2.11/jaxb-xjc-2.2.11.jar (1016 KB at 94.7 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/xml/dtd-parser/dtd-parser/1.1/dtd-parser-1.1.jar
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/codemodel/2.2.11/codemodel-2.2.11.jar (149 KB at 12.1 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-tools/2.21/istack-commons-tools-2.21.jar
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/dtd-parser/dtd-parser/1.1/dtd-parser-1.1.jar (54 KB at 4.4 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.jar
Downloaded: https://repo.maven.apache.org/maven2/com/sun/istack/istack-commons-tools/2.21/istack-commons-tools-2.21.jar (25 KB at 1.9 KB/sec)
Downloading: https://repo.maven.apache.org/maven2/org/apache/ant/ant-launcher/1.7.0/ant-launcher-1.7.0.jar
Downloaded: https://repo.maven.apache.org/maven2/org/apache/ant/ant-launcher/1.7.0/ant-launcher-1.7.0.jar (12 KB at 0.7 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xml/bind/external/rngom/2.2.11/rngom-2.2.11.jar (305 KB at 19.5 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/glassfish/jaxb/jaxb-runtime/2.2.11/jaxb-runtime-2.2.11.jar (1008 KB at 56.0 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/com/sun/xsom/xsom/20140925/xsom-20140925.jar (403 KB at 22.1 KB/sec)
Downloaded: https://repo.maven.apache.org/maven2/org/apache/ant/ant/1.7.0/ant-1.7.0.jar (1260 KB at 65.5 KB/sec)
[INFO] Up-to-date check for source resources [[file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml, file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/pom.xml]] and target resources [[]].
[INFO] Sources are not up-to-date, XJC will be executed.
[ERROR] Error while generating code.Location [ file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml{6,52}].
org.xml.sax.SAXParseException; systemId: file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml; lineNumber: 6; columnNumber: 52; 具有相同名称 "hello.wsdl.RemoteException" 的类/接口已在使用。请使用类定制设置来解决此冲突。
	at com.sun.tools.xjc.util.CodeModelClassFactory.createClass(CodeModelClassFactory.java:121)
	at com.sun.tools.xjc.util.CodeModelClassFactory.createClass(CodeModelClassFactory.java:82)
	at com.sun.tools.xjc.generator.bean.ImplStructureStrategy$1.createClasses(ImplStructureStrategy.java:82)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generateClassDef(BeanGenerator.java:440)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.getClazz(BeanGenerator.java:472)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.<init>(BeanGenerator.java:197)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generate(BeanGenerator.java:169)
	at com.sun.tools.xjc.model.Model.generateCode(Model.java:288)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.generateCode(XJC22Mojo.java:66)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:41)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:28)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.doExecute(RawXJC2Mojo.java:505)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.execute(RawXJC2Mojo.java:328)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
[ERROR] Error while generating code.Location [ file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml{41,48}].
org.xml.sax.SAXParseException; systemId: file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml; lineNumber: 41; columnNumber: 48; (与上一错误相关) 在此处生成了其他 "RemoteException"。
	at com.sun.tools.xjc.util.CodeModelClassFactory.createClass(CodeModelClassFactory.java:124)
	at com.sun.tools.xjc.util.CodeModelClassFactory.createClass(CodeModelClassFactory.java:82)
	at com.sun.tools.xjc.generator.bean.ImplStructureStrategy$1.createClasses(ImplStructureStrategy.java:82)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generateClassDef(BeanGenerator.java:440)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.getClazz(BeanGenerator.java:472)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.<init>(BeanGenerator.java:197)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generate(BeanGenerator.java:169)
	at com.sun.tools.xjc.model.Model.generateCode(Model.java:288)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.generateCode(XJC22Mojo.java:66)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:41)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:28)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.doExecute(RawXJC2Mojo.java:505)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.execute(RawXJC2Mojo.java:328)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
[ERROR] Error while generating code.Location [ file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml{6,52}].
com.sun.istack.SAXParseException2; systemId: file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml; lineNumber: 6; columnNumber: 52; 两个声明导致 ObjectFactory 类中发生冲突。
	at com.sun.tools.xjc.ErrorReceiver.error(ErrorReceiver.java:86)
	at com.sun.tools.xjc.generator.bean.ObjectFactoryGeneratorImpl.populate(ObjectFactoryGeneratorImpl.java:337)
	at com.sun.tools.xjc.generator.bean.PublicObjectFactoryGenerator.populate(PublicObjectFactoryGenerator.java:63)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generateClassBody(BeanGenerator.java:568)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.<init>(BeanGenerator.java:261)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generate(BeanGenerator.java:169)
	at com.sun.tools.xjc.model.Model.generateCode(Model.java:288)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.generateCode(XJC22Mojo.java:66)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:41)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:28)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.doExecute(RawXJC2Mojo.java:505)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.execute(RawXJC2Mojo.java:328)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
[ERROR] Error while generating code.Location [ file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml{41,48}].
com.sun.istack.SAXParseException2; systemId: file:/Users/fanhongling/Downloads/workspace/src/github.com/jpuigsegur/spring-cloud-netflix-sample/msa-sms/src/main/schemas/MasInterfaceForService.wsdl.xml; lineNumber: 41; columnNumber: 48; (与上一错误有关) 这是另一个声明。
	at com.sun.tools.xjc.ErrorReceiver.error(ErrorReceiver.java:86)
	at com.sun.tools.xjc.generator.bean.ObjectFactoryGeneratorImpl.populate(ObjectFactoryGeneratorImpl.java:339)
	at com.sun.tools.xjc.generator.bean.PublicObjectFactoryGenerator.populate(PublicObjectFactoryGenerator.java:63)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generateClassBody(BeanGenerator.java:568)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.<init>(BeanGenerator.java:261)
	at com.sun.tools.xjc.generator.bean.BeanGenerator.generate(BeanGenerator.java:169)
	at com.sun.tools.xjc.model.Model.generateCode(Model.java:288)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.generateCode(XJC22Mojo.java:66)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:41)
	at org.jvnet.mjiip.v_2_2.XJC22Mojo.doExecute(XJC22Mojo.java:28)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.doExecute(RawXJC2Mojo.java:505)
	at org.jvnet.jaxb2.maven2.RawXJC2Mojo.execute(RawXJC2Mojo.java:328)
	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:207)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:153)
	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:145)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:116)
	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:80)
	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:51)
	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:307)
	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:193)
	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:106)
	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:863)
	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:288)
	at org.apache.maven.cli.MavenCli.main(MavenCli.java:199)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 41.905 s
[INFO] Finished at: 2017-07-14T06:23:48-07:00
[INFO] Final Memory: 26M/331M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.jvnet.jaxb2.maven2:maven-jaxb2-plugin:0.13.1:generate (default-cli) on project msa-sms: Failed to compile input schema(s)! Error messages should have been provided. -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```
