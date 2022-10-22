package udemy_master_class.step_1.task_2;

public class A implements B, C, D {
}

interface B extends E {}
interface C extends F {}
interface D extends F, G{}
interface E {}
interface F {}
interface G {}