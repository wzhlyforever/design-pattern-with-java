package com.wx.decorator.general;

/**
 * @program: design-pattern-with-java
 * @description:  装饰器模式
 * 定义：在不改变原有对象的基础上，动态的给一个对象添加一些额外的职责
 * 装饰器模式提供了比子类更有弹性的的替代方案，扩展原有对象的功能，将功能附加到对象上，因此核心功能是功能扩展，
 * @author: Mr.Wang
 * @create: 2021-05-18 13:10
 **/
public class Client {

    public static void main(String[] args) {
        Component c1 = new ConcreteComponent();
        Deocrator deocratorA = new ConcreteDeocratorA(c1);
        //给对象透明的增加功能A并调用
        deocratorA.operation();

    }

    // 抽象组件
    static abstract class Component {

        public abstract void operation();
    }

    //具体组件
    static class ConcreteComponent extends Component {

        @Override
        public void operation() {
            System.out.println("处理业务逻辑");
        }
    }

    static abstract class Deocrator extends Component {
        private Component component;

        public Deocrator(Component component) {
            this.component = component;
        }

        public void operation() {
           component.operation();
        }

    }

    static class ConcreteDeocratorA extends Deocrator {

        public ConcreteDeocratorA(Component component){
            super(component);
        }

        public void operation() {
            operationFirst();
            super.operation();
            operationLast();
        }

        private void operationLast() {
        }

        private void operationFirst() {
        }
    }

    static class ConcreteDeocratorB extends Deocrator {

        public ConcreteDeocratorB(Component component){
            super(component);
        }

        public void operation() {
            operationFirst();
            super.operation();
            operationLast();
        }

        private void operationLast() {
        }

        private void operationFirst() {
        }
    }
}
