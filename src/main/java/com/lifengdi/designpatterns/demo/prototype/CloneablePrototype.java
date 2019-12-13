package com.lifengdi.designpatterns.demo.prototype;

import lombok.Data;

import java.io.*;
import java.util.Objects;

/**
 * 原型模式-浅克隆（实现Cloneable接口）
 * 原型（Prototype）模式的定义如下：用一个已经创建的实例作为原型，
 * 通过复制该原型对象来创建一个和原型相同或相似的新对象。
 * 在这里，原型实例指定了要创建的对象的种类。
 * 用这种方式创建对象非常高效，根本无须知道对象创建的细节。
 *
 * 原型模式的克隆分为浅克隆和深克隆，
 * Java 中的 Object 类提供了浅克隆的 clone() 方法，
 * 具体原型类只要实现 Cloneable 接口就可实现对象的浅克隆，
 * 这里的 Cloneable 接口就是抽象原型类。
 *
 * 浅拷贝：仅仅克隆基本类型变量，而不克隆引用类型的变量
 * 深克隆：既克隆基本类型变量，也克隆引用类型变量
 * @author 李锋镝
 * @date Create at 14:02 2019/12/13
 */
@Data
public class CloneablePrototype implements Cloneable, Serializable{

    private static final long serialVersionUID = 490320022607137415L;

    // 上文所说的浅拷贝只会克隆基本数据属性，而不会克隆引用其他对象的属性，
    // 但String对象又不属于基本属性，这又是为什么呢？
    //
    // 这是因为String对象是不可修改的对象，每次修改其实都是新建一个新的对象，
    // 而不是在原有的对象上修改，所以当修改String属性时其实是新开辟一个空间存储String对象，
    // 并把引用指向该内存，而克隆出来的对象的String属性还是指向原有的内存地址，
    // 所以String对象在浅克隆中也表现得与基本属性一样。
    private String name;

    private int age;

    private Job job;

    /**
     * 浅拷贝
     * @return Object
     * @throws CloneNotSupportedException CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深克隆
     * @return CloneablePrototype
     * @throws CloneNotSupportedException CloneNotSupportedException
     */
    CloneablePrototype deepClone() throws CloneNotSupportedException {
        CloneablePrototype cloneProtoType = (CloneablePrototype)super.clone();
        Job cloneJob = (Job)cloneProtoType.getJob().clone();
        cloneProtoType.setJob(cloneJob);
        return cloneProtoType;
    }

    /**
     * 深克隆（序列化实现）
     * @return CloneablePrototype
     * @throws IOException IOException
     * @throws ClassNotFoundException ClassNotFoundException
     */
    CloneablePrototype deepCopy() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //将当前这个对象写到一个输出流当中，，因为这个对象的类实现了Serializable这个接口，所以在这个类中
        //有一个引用，这个引用如果实现了序列化，那么这个也会写到这个输出流当中
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (CloneablePrototype)ois.readObject();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CloneablePrototype that = (CloneablePrototype) o;
        return age == that.age &&
                Objects.equals(name, that.name) &&
                Objects.equals(job, that.job);
    }

    /**
     * 两个对象相等，hashcode一定相等
     * 两个对象不等，hashcode不一定不等
     * hashcode相等，两个对象不一定相等
     * hashcode不等，两个对象一定不等
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {

        return Objects.hash(name, age, job);
    }
}
