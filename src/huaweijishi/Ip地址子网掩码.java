package huaweijishi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ip地址子网掩码 {
    private static boolean isValidFormat(String ip) {
        boolean result = true;
        if (ip == null || "".equals(ip)) {
            result = false;
        }
        Pattern pattern = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher = pattern.matcher(ip);
        if (matcher.matches()) {
            String[] numbers = ip.split("\\.");
            for (String num : numbers) {
                int n = Integer.valueOf(num);
                if (n < 0 || n > 255) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
    private static boolean isValidMaskCode(String maskCode) {
        boolean result = true;
        String[] numbers = maskCode.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String num : numbers) {
            int n =Integer.valueOf(num);
            sb.append(binaryString(n));
        }
        int Index0 = sb.indexOf("0");
        int Index1 = sb.lastIndexOf("1");

        if (Index0 < Index1) {
            result = false;
        }
        return result;
    }
    private static String binaryString(int num) {
        StringBuilder sb = new StringBuilder();
        int flag = 1 << 7;
        for (int i = 0; i < 8; i++) {
            int val = (flag & num) == 0 ? 0 : 1;
            sb.append(val);
            num <<= 1;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int typeA = 0;
        int typeB = 0;
        int typeC = 0;
        int typeD = 0;
        int typeE = 0;
        int errorIpOrMaskCode = 0;
        int privateIp = 0;
        //牛客上改为input.hasNext()
        while (!input.hasNext("exit")) {
            String ipt = input.nextLine();
            String[] ipAndMaskCode = ipt.split("~");
            String ip = ipAndMaskCode[0];
            String maskCode = ipAndMaskCode[1];
            if (!isValidFormat(ip) || !isValidFormat(maskCode)) {
                errorIpOrMaskCode++;
                continue;
            }
            if (!isValidMaskCode(maskCode)) {
                errorIpOrMaskCode++;
                continue;
            }
            String str = ip.substring(0, ip.indexOf("."));
            int n = Integer.parseInt(str);
            if (n >= 1 && n < 127) {
                typeA++;
            } else if (n >= 128 && n < 192) {
                typeB++;
            } else if (n >= 192 && n < 224) {
                typeC++;
            } else if (n >= 224 && n < 240) {
                typeD++;
            } else if (n >= 240 && n <= 255) {
                typeE++;
            }
            // 判断是否是私网
            String ipSubStr  = ip.substring(ip.indexOf(".") + 1);
            String snStr = ipSubStr .substring(0, ipSubStr .indexOf("."));
            int n2 = Integer.parseInt(snStr);

            if ((n == 10) || (n == 172 && n2 >= 16 && n2 <= 32) || (n == 192 && n2 == 168)) {
                privateIp++;
            }
        }
        input.close();
        System.out.printf("%d %d %d %d %d %d %d%n", typeA, typeB, typeC, typeD, typeE, errorIpOrMaskCode, privateIp);

    }
}
