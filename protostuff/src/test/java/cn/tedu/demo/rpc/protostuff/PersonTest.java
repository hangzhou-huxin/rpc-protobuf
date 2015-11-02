package cn.tedu.demo.rpc.protostuff;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;



import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import org.junit.Test;

public class PersonTest {
	
	@Test
	public void test(){
		
		Schema<Person> schema = RuntimeSchema.getSchema(Person.class);  
        Person person1 = new Person();  
        person1.setId(10086) ;  
        person1.setName("ken") ;  
        person1.setEmail( "ken@iamcoding.com");  
        // 缓存buff  
        LinkedBuffer buffer = LinkedBuffer.allocate(1024);  
        // 序列化成protobuf的二进制数据  
        byte[] data = ProtobufIOUtil.toByteArray(person1, schema, buffer);  
  
  
        // 反序列化  
        Person person2 = new Person();  
        ProtobufIOUtil.mergeFrom(data, person2, schema);  
        System.out.println(person2.getId());  
	}

}
