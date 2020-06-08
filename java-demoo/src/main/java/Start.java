/**
 * @author CBeann
 * @create 2020-02-20 2:49
 */
public class Start {

    public static void main(String[] args) throws Exception{

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDate localDate = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(2020, 6, 6);
        System.out.println(localDate);
        LocalDateTime localDateTime =LocalDateTime.now();
        System.out.println(localDateTime);
        int i = localDate.compareTo(localDate2);
        System.out.println(i);

        // 根据系统时间返回当前时间并设置为UTC。
        Clock clock = Clock.systemUTC();
        System.out.println("Clock : " + clock);

        // 根据系统时钟区域返回时间
        Clock defaultClock = Clock.systemDefaultZone();
        System.out.println("Clock : " + clock);


    }
}
