package Lesson5;

public class Person {

    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    /*
     * Конструктор класса должен заполнять эти поля при создании объекта
     */

    Person(String name, String position, String email, String phone, int salary, int age)
    {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;

    }

    /*
     * Внутри класса «Сотрудник» написать метод, который выводит информацию
     * об объекте в консоль
     */
    public void printInfo()
    {
        System.out.println("Имя: " + name);
        System.out.println("Должность: " + position);
        System.out.println("e-mail: " + email);
        System.out.println("Teл.: " + phone);
        System.out.println("Зарплата: " + salary);
        System.out.println("Возраст: " + age);
        System.out.println();
    }

    public int getAge()
    {
        return age;
    }

}
