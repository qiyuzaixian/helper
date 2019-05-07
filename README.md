# hps

#### 介绍
HPS

#### 软件架构
软件架构说明
![输入图片说明](https://images.gitee.com/uploads/images/2019/0118/103002_a332dd74_1855099.jpeg "未命名文件.jpg")


#### 安装教程

1. git clone https://xxx.git
2. java -jar hps.jar

#### 生产部署说明

1. 打包
    - mvn clean package
    - 控制台结果：Building jar: D:\workspaces\hps\target\helper.jar
2. 上传服务器方法
    - window ftp命令远程上传
    - ftp 客户端上传工具上传
3. 服务器信息

应用类别 | 服务器 | 发布地址 | 端口服务 | 日志路径
---- | ------ | ------ | ------ | ----
helper.jar | 192.168.1.43 | /opt/server  |8081(手动)| /data/logs
helper.jar | 192.168.1.43 | /opt/server  |8082(手动)| /data/logs
helper.jar | 192.168.1.43 | /opt/server  |8083(手动)| /data/logs
helper.jar | 192.168.1.44 | /opt/server  |8081(手动)| /data/logs
helper.jar | 192.168.1.44 | /opt/server  |8082(手动)| /data/logs
helper.jar | 192.168.1.44 | /opt/server  |8083(手动)| /data/logs
UI/dist | 192.168.1.43 | /usr/share/tomcat/webapps  |8080(自动)| /data/logs
UI/dist | 192.168.1.44 | /usr/share/tomcat/webapps  |8080(自动)| /data/logs

### 后端服务启动脚本
 #### 后端服务停止
    1. ps -ef|grep java(或)
    2. ps -ef|grep helper.jar|grep java |grep -v grep | awk '{print $2}' (或)
    杀掉以上的进程
    kill -9 PID
    
 #### 后端服务启动
    setsid java -jar -Dserver.port=8082 helper.jar --spring.profiles.active=prod
 #### 前端
    直接替换dist文件后重启|启动|停止： 
    systemctl tomcat restart|start|stop
 #### 服务进程/端口检查
    进程： ps -ef|grep java
    端口： ss -antl


#### 192.168.1.43 和 192.168.1.44 UI项目发布步骤
1. 打开Linux客户端工具MobaXterm。
	在左侧导航上面选中指定机器后右键->excute 进入
2. 检查当前服务运行的进程或端口
	- cd /usr/share/tomcat/webapps/
	- 替换现有dist,如需要备份，建议在本地做好备份，服务器要敲命令不方便。
3. 重启tomcat （启动start|重启restart|停止stop）
    - systemctl restart tomcat 
    - ss -antl (验证部署->检查8080端口是否存在？正确：失败)  

