import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    static void calcBill()
    {
        int tot=0;
        try{
            BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\gurki\\OneDrive\\Desktop\\JavaProject\\YourOrder.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("bill.txt",true));

            String str1=new String();
            while((str1=br.readLine())!=null)
            {
                int a=0,qu=0;
                for(int i=0;i<str1.length();i++)
                {
                    if(str1.charAt(i)==',')
                    {
                        a++;
                    }
                    if(a==2)
                    {
                        qu=i;
                        break;
                    }
                }

                qu+=3;
                StringBuilder str2=new StringBuilder();
                for(int i=qu+1;i<str1.length();i++)
                {
                    if(str1.charAt(i)!='\t')
                    {
                        str2.append(str1.charAt(i));
                    }
                    else
                        break;
                }
                String str3=str2.toString();
                int cInt = Integer.parseInt(str3);

                int qu2=0,b=0;
                for(int i=0;i<str1.length();i++)
                {
                    if(str1.charAt(i)==',')
                    {
                        b++;
                    }
                    if(b==3)
                    {
                        qu2=i;
                        break;
                    }
                }
                StringBuilder str4=new StringBuilder();
                for(int i=qu2+1;i<str1.length();i++)
                {
                    str4.append(str1.charAt(i));
                }

                //System.out.println(str4);
                String str5=str4.toString();
                //System.out.println(str3);
                int qInt = Integer.parseInt(str5);
                bw.write(str1+";"+qInt*cInt+"\n");
                tot+=qInt*cInt;
            }
            br.close();
            BufferedReader reader=new BufferedReader(new FileReader("bill.txt"));
            bw.write("\n"+tot+"\n");

            bw.write("-----\n");

            bw.close();
            reader.close();

        }
        catch(IOException io){
            System.out.println("IO EXCEPTION THROWN");
        }
    }

    // static void tot(){
    //     try{
    //         BufferedReader reader=new BufferedReader(new FileReader("bill.txt"));
    //         BufferedWriter bw=new BufferedWriter(new FileWriter("bill.txt",true));

    // int temp=0;
    // String calc=new String();
    // //bw.write("total is ");

    // while((calc=reader.readLine())!=null)
    // {
    //     temp=temp+Integer.parseInt(calc);
    // }
    // bw.write("\n"+temp+"\n");

    // bw.write("-----\n");
    // reader.close();bw.close();
    //     }
    //     catch(IOException io)
    //     {
    //         System.out.println("IO exception");
    //     }
    // }

    public static void main(String[] args) {
        calcBill();
        //tot();
    }

}
