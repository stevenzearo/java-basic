### serialVersionUID
#### 作用
- 用于类的反序列化时类的验证
- 当类的serialVersionUID与反序列化时读取到的serialVersionUID不一致，则会抛出InvalidClassException
#### 修饰
为保证类验证时一致通常用private static
final修饰
