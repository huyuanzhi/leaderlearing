package homework2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/7
 * @project: leaderlearing
 * @packageName: homework2
 * @description: XXXXXX
 */
public class Q3 {

    public static void main(String[] args) throws Exception {

        /*FileWriter fileWriter = new FileWriter("d://q3.dat");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        Random random;
        long ago = System.currentTimeMillis();
        for(int i=0;i<10000000;i++){
            random = new Random();
            String name = UUID.randomUUID().toString().substring(0,5);
            int salary = random.nextInt(15)+5;
            int bounds = random.nextInt(5);
            writer.write(name+","+salary+","+bounds);
            writer.newLine();
        }
        writer.close();
        fileWriter.close();
        System.out.println("耗时"+(System.currentTimeMillis()-ago));*/
        long current = System.currentTimeMillis();
        BufferedReader reader = new BufferedReader(new FileReader("d://q3.dat"));
        String str;
        Map<String,Map> groups = new HashMap();
        Salary salary;
        Map group;
        while((str = reader.readLine()) != null){
            String[] values = str.split(",");
            salary = new Salary(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]));
            String prefix = salary.getNamePrefixTwo();
            if(groups.containsKey(prefix)){
                group = groups.get(prefix);
                group.put("salarySum",Integer.parseInt(group.get("salarySum").toString())+salary.getYearSalary());
                group.put("people",Integer.parseInt(group.get("people").toString())+1);
            }else{
                group = new HashMap();
                group.put("salarySum",salary.getYearSalary());
                group.put("people",1);
                groups.put(prefix,group);
            }
        }
        List<Map> list = new ArrayList();
        Map s;
        for(Map.Entry<String,Map> entry:groups.entrySet()){
            s = entry.getValue();
            s.put("group",entry.getKey());
            list.add(s);
        }
        Collections.sort(list, (o1, o2) -> ((Integer) o2.get("salarySum")).compareTo((Integer) o1.get("salarySum")));
        System.out.println("排序分组用时:"+(System.currentTimeMillis()-current));
        for(int i=0;i<10;i++){
            System.out.println(list.get(i).get("group")+","+list.get(i).get("salarySum")+"万,"+list.get(i).get("people")+"人");
        }
    }

    private static class Salary{
        private String name;
        private int salary;
        private int bounds;

        public Salary(String name, int salary, int bounds) {
            this.name = name;
            this.salary = salary;
            this.bounds = bounds;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getBounds() {
            return bounds;
        }

        public void setBounds(int bounds) {
            this.bounds = bounds;
        }

        public Integer getYearSalary(){
            return this.salary*13+bounds;
        }

        public String getNamePrefixTwo(){
            return getName().substring(0,3);
        }
    }
}
