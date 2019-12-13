package com.lifengdi.designpatterns.demo.prototype;

/**
 * @author 李锋镝
 * @date Create at 14:03 2019/12/13
 */
public class PrototypeTest {

    public static void main(String[] args) {
        CloneablePrototype prototype = new CloneablePrototype();
        prototype.setName("李锋镝");
        prototype.setAge(25);
        prototype.setJob(Job.builder().company("淘车").name("java").build());

        System.out.println(prototype);

        try {
            CloneablePrototype cloneProtoType = (CloneablePrototype)prototype.clone();
            CloneablePrototype deepCloneProtoType = prototype.deepClone();
            CloneablePrototype deepCopyProtoType = prototype.deepCopy();
            System.out.println(cloneProtoType);
            System.out.println(cloneProtoType.hashCode());
            System.out.println(prototype.hashCode());
            System.out.println(prototype.equals(cloneProtoType));
            System.out.println(prototype == cloneProtoType);

            prototype.getJob().setCompany("TaoChe");
            System.out.println(prototype);

            System.out.println(deepCloneProtoType);
            System.out.println(deepCopyProtoType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
