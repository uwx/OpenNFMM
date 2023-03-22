package nfm.open;

import nfm.open.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Maxine on 03/07/2020.
 *
 * @author Maxine
 * @since 03/07/2020
 */
public class Graphist {
    private final static String[] carRads = {
            "2000tornados", "formula7", "canyenaro", "lescrab", "nimi", "maxrevenge", "leadoxide", "koolkat", "drifter",
            "policecops", "mustang", "king", "audir8", "masheen", "radicalone", "drmonster"
    };

    public static void graph() throws IOException {
        @SuppressWarnings({"unchecked", "rawtypes"}) Pair<Integer, Stat>[] stats = IntStream.range(0, CarDefine.SIXTEEN).mapToObj(cn -> new Pair<>(cn, new Stat(cn))).toArray(Pair[]::new);

        ContO[] carContos = new ContO[carRads.length];

        FileUtil.loadFiles(
                "data/cars",
                carRads,
                prep -> new File(prep.parent, prep.file + ".rad").toPath(),
                (bytes, id) -> {
                    carContos[id] = new ContO(bytes);
                    if (!carContos[id].shadow) {
                        throw new RuntimeException("car " + CarDefine.names[id] + " does not have a shadow");
                    }
                });

        List<Data> data = new ArrayList<>();

        for (int car1 = 0; car1 < carContos.length; car1++)
        for (int car2 = 0; car2 < carContos.length; car2++) {
            Stat stat1 = stats[car1].value;
            Stat stat2 = stats[car2].value;
            ContO conto1 = carContos[car1];
            ContO conto2 = carContos[car2];

            Mad mad1 = new Mad(stat1, 1); // collide between AI cars (for balance)
            Mad mad2 = new Mad(stat2, 2);

            for (float power1 = 0.40F; power1 <= 1.00F; power1 += 0.05F)
            for (float power2 = 0.40F; power2 <= 1.00F; power2 += 0.05F)
            for (int gear1 = 0; gear1 < 3; gear1++)
            for (int gear2 = 0; gear2 < 3; gear2++) {

                mad1.reseto(car1, conto1);
                mad2.reseto(car2, conto2);

                mad1.power = power1;
                mad2.power = power2;

                setSpeedToPower(stat1, mad1, gear1);
                setSpeedToPower(stat2, mad2, gear2);

                pushSpeedToAxes(mad1, conto1);
                pushSpeedToAxes(mad2, conto2);

                mad1.collideSim(conto1, mad2, conto2);
                mad2.collideSim(conto2, mad1, conto1); // collision is bidirectional

                System.out.println(
                        "Inputs: " + carRads[car1] + " at " + (int)(power1 * 100) + "% (" + getSpeedKmh(mad1.speed) + "kmh) VS " + carRads[car2] + " at " + (int)(power2 * 100) + "% (" + getSpeedKmh(mad2.speed) + "kmh) " +
                        "Result: " + ((mad1.hitmag / (float) stat1.maxmag) * 100) + " / " + ((mad2.hitmag / (float) stat2.maxmag) * 100)
                );

                data.add(new Data(
                        stat1.names, stat2.names, power1, power2, getSpeedKmh(mad1.speed), getSpeedKmh(mad2.speed), ((mad1.hitmag / (float) stat1.maxmag) * 100), ((mad2.hitmag / (float) stat2.maxmag) * 100)
                ));
            }

        }

        System.out.println(data.size() + " data points");
        List<String> result = new ArrayList<>();
        for (Data datum : data) {
            result.add(
                    datum.name1 + "," +
                    datum.name2 + "," +
                    datum.power1 + "," +
                    datum.power2 + "," +
                    datum.speedKmh1 + "," +
                    datum.speedKmh2 + "," +
                    datum.damPercent1 + "," +
                    datum.damPercent2);
        }

        Files.write(Paths.get("computed.csv"), result);

        System.exit(0);

        //
    }

    private static void setSpeedToPower(Stat stat1, Mad mad1, int gear) {
        mad1.speed = stat1.swits[gear] / 2F + mad1.power * stat1.swits[gear] / 196.0F;
    }

    private static float getSpeedKmh(float speed) {
        return speed * 1.4F * 21.0F * 60.0F * 60.0F / 100000.0F;
    }

    private static void pushSpeedToAxes(Mad mad, ContO conto) {
        int xspeed = -(int) (mad.speed * Medium.sin(conto.xz) * Medium.cos(mad.pzy));
        int zspeed = (int) (mad.speed * Medium.cos(conto.xz) * Medium.cos(mad.pzy));
        int yspeed = -(int) (mad.speed * Medium.sin(mad.pzy));

        for (int i = 0; i < 4; i++) {
            mad.scx[i] = xspeed;
            mad.scz[i] = zspeed;
            mad.scy[i] = yspeed;
        }
    }

    public static class Pair<K, V> {
        public final K key;
        public final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class Data {
        private final String name1;
        private final String name2;
        private final float power1;
        private final float power2;
        private final float speedKmh1;
        private final float speedKmh2;
        private final float damPercent1;
        private final float damPercent2;

        public Data(String name1, String name2, float power1, float power2, float speedKmh1, float speedKmh2, float damPercent1, float damPercent2) {
            this.name1 = name1;
            this.name2 = name2;
            this.power1 = power1;
            this.power2 = power2;
            this.speedKmh1 = speedKmh1;
            this.speedKmh2 = speedKmh2;
            this.damPercent1 = damPercent1;
            this.damPercent2 = damPercent2;
        }
    }
}
