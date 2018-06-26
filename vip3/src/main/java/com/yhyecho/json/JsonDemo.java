package com.yhyecho.json;

import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.yhyecho.entity.Person;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by Echo on 5/22/18.
 */
public class JsonDemo {

    private static Person init() {
        Person person = new Person();
        person.setName("Echo");
        person.setAge(18);
        return person;
    }

    public static void main(String[] args) throws IOException {
        // jackson
        executeWithJackson();

        // fastjson
        executeWithFastJackson();

        //protobuf
        executeWithProtoBuf();

        // hession
        executeWithHession();
    }

    private static void executeWithJackson() throws IOException {
        Person person = init();

        ObjectMapper mapper = new ObjectMapper();
        byte[] writeBytes = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            writeBytes = mapper.writeValueAsBytes(person);
        }

        System.out.println("Jackson序列化:" + (System.currentTimeMillis() - start) + "ms" + "总大小=>" + writeBytes.length);

        Person person1 = mapper.readValue(writeBytes, Person.class);
        System.out.println(person1);
    }

    private static void executeWithFastJackson() throws IOException {
        Person person = init();

        String text = null;
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            text = JSON.toJSONString(person);
        }

        System.out.println("FastJson序列化:" + (System.currentTimeMillis() - start) + "ms" + "总大小=>" + text.getBytes().length);

        Person person1 = JSON.parseObject(text, Person.class);
        System.out.println(person1);
    }

    private static void executeWithProtoBuf() throws IOException {
        Person person = init();

        Codec<Person> personCodec = ProtobufProxy.create(Person.class, false);
        long start = System.currentTimeMillis();

        byte[] bytes = null;
        for (int i = 0; i < 100; i++) {
            bytes = personCodec.encode(person);
        }

        System.out.println("ProtoBuf序列化:" + (System.currentTimeMillis() - start) + "ms" + "总大小=>" + bytes.length);

        Person person1 = personCodec.decode(bytes);
        System.out.println(person1);
    }

    private static void executeWithHession() throws IOException {
        Person person = init();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            ho.writeObject(person);
            if (i == 0) {
                System.out.println("序列化大小:" + os.toByteArray().length);
            }
        }

        System.out.println("Hession序列化:" + (System.currentTimeMillis() - start) + "ms");

        HessianInput hi = new HessianInput(new ByteArrayInputStream(os.toByteArray()));
        Person person1 = (Person) hi.readObject();
        System.out.println(person1);
    }
}
