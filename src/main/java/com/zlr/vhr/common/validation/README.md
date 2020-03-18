#### 背景介绍

- JSR-303 是 JAVA EE 6 中的一项子规范，叫做 Bean Validation，官方参考实现是Hibernate Validator。
- 自定义注解，在原注解的基础，增加了一些新的功能。

#### 设计思想

- 一个注解，一个功能

- 复杂校验，尽量手动写逻辑代码校验

  

####  快速上手

``` java
public class HelloController {

	/**
	 * 在方法上形参前加@Validated
	 * {@link org.springframework.validation.annotation.Validated}
	 */
	public String sayHi(@RequestBody @Validated HelloRequest request) {

		return "Hello World!";
	}

}
```

``` java
/**
 * 仅当gender属性值为gril时，属性wechat不能为null或空
 */
@NotEmptyType(field = "wechat", message = "wechat不能为空", depField = "gender", depValue = "gril")
public class HelloRequest {

	/**
	 * name属性值只能为jack或者rose。如果属性值为null,或者其他值。则提示name值不合法<br>
	 */
	@NotEmptyExt(value = { "jack", "rose" }, message = "name值不合法")
	private String name;

	/**
	 * gender属性值不能为null或者空。否则提示gender不能为空<br>
	 */
	@NotEmpty(message = "gender不能为空")
	private String gender;

	private String wechat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

}
```





