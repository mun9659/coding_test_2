package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10814 {
    public static void main(String[] args) throws IOException {
        // 나이순 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Person[] persons = new Person[n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            persons[i] = new Person(age, name);
        }

        Arrays.sort(persons, (o1, o2) -> {
            return o1.age - o2.age;
        });

        for(Person p : persons) 
            sb.append(p.age).append(" ").append(p.name).append("\n");

        System.out.println(sb);
    }

    public static class Person {
        int age;
        String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age + " " + name + "\n";
        }

    }
}
