package Lesson6;

public class HomeWork6 {

    public static void main(String[] args) {
        float runDistance=0, swimDistance=0, jumpHeight=0;
        String animalType="Животное";
        Dog dog1=new Dog("Патрик",2010,"Серый");
        Dog dog2=new Dog("Белый клык",2015,"Серый");
        Dog dog3=new Dog("Шарик", 2012, "Коричневый");


        Cat cat1=new Cat("Кот в сапогах",2005,"Рыжий");
        Cat cat2=new Cat("Мики Маус",2010,"Черно-белый");
        Cat cat3=new Cat("Сильвестр",2007,"Серый");


        Animal[] animals=new Animal[12];
        animals[0]=dog1;
        animals[1]=dog2;
        animals[2]=dog3;
        animals[6]=cat1;
        animals[7]=cat2;
        animals[8]=cat3;

        for(int i=0;i<animals.length;i++){
            if(animals[i] instanceof Dog){
                runDistance=500;
                swimDistance=10;
                jumpHeight=0.5f;
                animalType="Собака: ";

            } else if(animals[i] instanceof Cat){
                runDistance=200;
                swimDistance=10;
                jumpHeight=2;
                animalType="Кот: ";
            }
            System.out.println(animalType + animals[i].getName()+". Цвет: "+animals[i].getColor()+". Лет: "+animals[i].getAge());
            System.out.println("Может пробежать: "+animals[i].getRunLimit()+" метров. Может проплыть: "+animals[i].getSwimLimit()+" метров. Может перепрыгнуть препятствие высотой: "+animals[i].getJumpLimit()+" метров.");
            animals[i].run(runDistance);
            animals[i].swim(swimDistance);
            animals[i].jump(jumpHeight);
        }


    }

}
