package homework2;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;

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

        long ago = System.currentTimeMillis();
        /*FileWriter fileWriter = new FileWriter("d://q3.dat");
        BufferedWriter writer = new BufferedWriter(fileWriter);
        Random random = ThreadLocalRandom.current();
        //Files.newBufferedWriter()
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0;i<10000000;i++){
            String name = UUID.randomUUID().toString().substring(0,5);
            int salary = random.nextInt(15)+5;
            int bounds = random.nextInt(5);
            stringBuffer.append(name+","+salary+","+bounds+"\n");
        }
        writer.write(stringBuffer.toString());
        writer.close();
        fileWriter.close();*/
        Map<String,List<Salary>> salaryGroup = Files.newBufferedReader(Paths.get("d://q3.dat"))
                .lines().map(Salary::new).collect(Collectors.groupingBy(Salary::getNamePrefixTwo));
        List<SalaryGroup> group = salaryGroup.entrySet().stream().map(SalaryGroup::new).collect(Collectors.toList());
        group.stream().sorted(Comparator.comparing(SalaryGroup::getSumSalary).reversed())
                .limit(10).forEach(System.out::println);
        System.out.println("耗时:"+(System.currentTimeMillis()-ago));
        Integer[] init = {0,0};
        //Files.lines(Paths.get("d://q3.dat")).collect(groupingByConcurrent(prefix,mapping(single,reducing(init,))));
    }



    static UnaryOperator<String> prefix = s -> s.substring(0,3);
    static Function<String,Integer[]> single = s -> {
        Integer[] re ={0,0};
        String[] values = s.split(",");
        re[0] = Integer.parseInt(values[1]);
        re[1] = Integer.parseInt(values[2]);
        return re;
    };

    //static Function<Integer[],>

    private static class Salary{
        private String name;
        private int salary;
        private int bounds;

        public Salary(String value){
            String[] values = value.split(",");
            this.name = values[0];
            this.salary = Integer.parseInt(values[1]);
            this.bounds = Integer.parseInt(values[2]);
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

    private static class SalaryGroup{
        private String namePrefix;
        private Integer sumSalary;
        private int count;

        public SalaryGroup() {
        }

        public SalaryGroup(Map.Entry<String,List<Salary>> entry) {
            this.namePrefix = entry.getKey();
            this.sumSalary = entry.getValue().stream().mapToInt(s -> s.getYearSalary()).sum();
            this.count = entry.getValue().size();
        }

        public String getNamePrefix() {
            return namePrefix;
        }

        public void setNamePrefix(String namePrefix) {
            this.namePrefix = namePrefix;
        }

        public Integer getSumSalary() {
            return sumSalary;
        }

        public void setSumSalary(Integer sumSalary) {
            this.sumSalary = sumSalary;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return this.getNamePrefix()+","+this.getSumSalary()+"万,"+this.getCount()+"人";
        }
    }
}
