import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        List<String> list = Arrays.asList("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"); 

        //Iterar sobre uma lista de Strings e imprimir no console usando lambda e streams.
        list.stream().forEach(s -> System.out.println(s));

        //Criar uma string que consiste na concatenação da inicial de cada String da lista.
        String result;
        result = list.stream().map(s -> s.substring(0, 1)).reduce((s1, s2) -> s1 + s2).get();
        System.out.println(result);

        System.out.println("\n");

        //Transformar uma lista de strings em strings maiúsculas (ou seja, alterando a lista original).
       List<String> listaMaiuscula = list.stream().map(String::toUpperCase).collect(Collectors.toList());
            listaMaiuscula.forEach(System.out::println);

        System.out.println("\n");

        //Contar  o  número  de  elementos  de  uma  lista  de  strings  que  possuem  pelo  menos  seis caracteres.
        long contador = list.stream().mapToLong(String::length).filter(e -> e >= 6).count();
        System.out.println(contador);

    }
}
