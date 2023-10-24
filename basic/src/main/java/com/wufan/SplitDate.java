package com.wufan;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.io.FileUtil;
import com.pojo.Xyz;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitDate {
    public static void main(String[] args) {
        //读取数据
        String filePath = "D:\\linshi\\04_head_400-500.gro";
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(filePath);

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            HashMap<Integer, Xyz> end = new HashMap<>();

            DecimalFormat df = new DecimalFormat("0.000");//保留6位小数
            String line = "";
            Integer count = 0;
            while ((line = bufferedReader.readLine()) != null) {
                //对数据进行处理
                line = line.trim();
                String[] split = line.split("\\s+");
                //split[3] 为数字
                //split[4] 为x轴
                if (split.length > 5) {
                    if (("P".equals(split[1]) || "O3".equals(split[1] )) && isNumeric(split[2])){
                        //序号
                        Integer num = Integer.valueOf(split[2]);
                        double x = Double.parseDouble(split[3]);
                        double y = Double.parseDouble(split[4]);
                        double z = Double.parseDouble(split[5]);

                        if(!end.containsKey(num)){
                            end.put(num,new Xyz(x,y,z));
                        }else {
                            Xyz xyz = end.get(num);
                            xyz.setX(Double.parseDouble(df.format(xyz.getX() + x)));
                            xyz.setY(Double.parseDouble((df.format(xyz.getY() + y))));
                            xyz.setZ(Double.parseDouble((df.format(xyz.getZ() + z))));
                            end.put(num,xyz);
                        }
                        if(num == 1){
                            count++;
                        }
                    }
                }

            }

            //对结果输出
            File file = new File("D:\\linshi\\outfile1.txt");
            if(file.exists()){
                file.delete();
            }

            File outFile2 = new File("D:\\linshi\\outfile2.txt");
            if(outFile2.exists()){
                outFile2.delete();
            }
            System.out.println("总共有：" + count + "组");

            Iterator<Map.Entry<Integer, Xyz>> iterator = end.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Integer, Xyz> next = iterator.next();
                Integer num = next.getKey();
                Xyz value = next.getValue();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(num);
                stringBuilder.append("\t");
                stringBuilder.append(value.getX());
                stringBuilder.append("\t");
                stringBuilder.append(value.getY());
                stringBuilder.append("\t");
                stringBuilder.append(value.getZ());
                stringBuilder.append("\r\n");
                String s = stringBuilder.toString();
                FileUtil.appendString(s,file, Charset.forName("UTF-8"));

                stringBuilder = new StringBuilder();
                stringBuilder.append(num);
                stringBuilder.append("\t");
                stringBuilder.append(df.format(value.getX() / count));
                stringBuilder.append("\t");
                stringBuilder.append(df.format(value.getY()/ count));
                stringBuilder.append("\t");
                stringBuilder.append(df.format(value.getZ()/ count));
                stringBuilder.append("\r\n");
                s = stringBuilder.toString();
                FileUtil.appendString(s,outFile2, Charset.forName("UTF-8"));

            }




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static boolean isNumeric(String str) {
        //Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");//这个也行
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;


    }
}
