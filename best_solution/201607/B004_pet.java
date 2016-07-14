//结构设计
//宠物队列
//需要实现的功能1：基本功能add(Pet) pollPet 
//需要实现的功能2：基本功能pollDog pollCat 
//需要实现的功能3：基本功能isEmpty isDogEmpty isCatEmpty 
import java.util.Stack;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class B004_pet {
    public static void main(String[] args) throws Exception {
//        Stack<Pet> stk = new Stack<Pet>();
        Pet p1 = new Dog("dog1");
        Pet p2 = new Cat("cat1");
        Pet p3 = new Cat("cat2");
        Pet p4 = new Dog("dog2");
//        stk.add(p1);
//        stk.add(p2);
//        stk.add(p3);
//        stk.add(p4);
//        Iterator<Pet> it = stk.iterator();
//        while(it.hasNext()) {
//            it.next().call();
//        }
        PetQueue pq = new PetQueue();
        pq.add(p1);
        pq.add(p2);
        pq.add(p3);
        pq.add(p4);
//        pq.pollCat().call();
//        pq.pollCat().call();
//        pq.pollDog().call();
//        pq.pollDog().call();
//        pq.pollCat().call();
        Pet tmp = null;
        tmp = pq.poll();
        tmp.call();
        tmp = pq.poll();
        tmp.call();
        tmp = pq.poll();
        tmp.call();
        tmp = pq.poll();
        tmp.call();
    }
    static abstract class Pet {
        protected String name;
        protected String type;
        public abstract void call();
        public String getName() {
            return name;
        }
        public String getType() {
            return type;
        }
    }
    static class Dog extends Pet {
        public Dog(String name) {
            this.name = name;
            this.type = "Dog";
        }
        public void call () {
            System.out.printf("I am Dog! My name is %s\n", name);
        }
    }
    static class Cat extends Pet {
        public Cat(String name) {
            this.name = name;
            this.type = "Cat";
        }
        public void call() {
            System.out.printf("I am Cat! My name is %s\n", name);
        }
    }
    static class PetQ {
        private Pet pet = null;
        private long count = 0l;
        public PetQ (Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet() {
            return this.pet;
        }
        public long getCount() {
            return this.count;
        }
        public String getPetType() {
            return pet.getType();
        }
    }
    static class PetQueue {
        private Queue<PetQ> dogQ = null;
        private Queue<PetQ> catQ = null;
        private long count = 0l;
        public PetQueue() {
            this.dogQ = new LinkedList<PetQ>();
            this.catQ = new LinkedList<PetQ>();
            count = 0l;
        }
        public void add(Pet pet) {
            String type = pet.getType();
            switch(type) {
                case "Cat":
                    catQ.add(new PetQ(pet, this.count ++));
                    break;
                case "Dog":
                    dogQ.add(new PetQ(pet, this.count ++));
                default:
                    break;
            }
        }
        public Pet poll() throws Exception {
            if (this.isEmpty())
                throw new Exception("栈为空栈");
            boolean isCatEmpty = this.isCatEmpty();
            boolean isDogEmpty = this.isDogEmpty();
            if (! isCatEmpty && ! isDogEmpty) {
                if (dogQ.peek().getCount() < catQ.peek().getCount())
                    return dogQ.poll().getPet();
                else
                    return catQ.poll().getPet();
            } else if (! isCatEmpty)
                return catQ.poll().getPet();
            else if (! isDogEmpty)
                return dogQ.poll().getPet();
            else
                throw new Exception("栈为空栈");
        }
        public Cat pollCat() throws Exception {
            if (catQ.isEmpty())
                throw new Exception("栈为空栈");
            else
                return (Cat)catQ.poll().getPet();
        }
        public Dog pollDog() throws Exception {
            if (dogQ.isEmpty())
                throw new Exception("栈为空栈");
            else
                return (Dog)dogQ.poll().getPet();
        }
        public boolean isDogEmpty() {
            return dogQ.isEmpty();
        }
        public boolean isCatEmpty() {
            return catQ.isEmpty();
        }
        public boolean isEmpty() {
            return this.isDogEmpty() && this.isCatEmpty();
        }
    }
}
