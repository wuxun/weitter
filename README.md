# weitter

## java web练习项目

- 类似微博的系统。follow其他用户，发送消息，查看其他用户的消息，修改自己头像等等。

## Usage

- Spring

- Spring MVC

- Mybatis

- Hibernate Validator

- Redis
	- 主要用于存储用户时间线的消息队列，减少查询次数

- Bootstrap

- Log4j

- [Cropper](https://github.com/fengyuanchen/cropper)

	- 图片剪裁上传

## 问题

- 目前发送只使用推的方式，如果follower过多，会出现明显发送延迟，要考虑消息队列异步发送。
- 粉丝数过多如何存储用户间关系。