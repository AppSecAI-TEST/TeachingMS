# TeachingMS
doc文件夹下存放项目相关文档

该项目开发环境及工具：
	IDEA + Maven + JDK8 + Mysql
主要技术：
	Spring Boot + SpringMVC + MyBatis

启动项目步骤：找到boot模块的RootApplication类，运行main方法

运行demo
Rest API路径：
	http://localhost:8080/swagger-ui.html
	
controller接口路径：
	http://localhost:8080/index/list

接口字段说明
	接口返回内容
		{
			resultCode: 0, //成功：0；失败：非0
			resultMsg: '', //失败原因（执行成功也可添加返回信息）
			data: [] //数据
		}
