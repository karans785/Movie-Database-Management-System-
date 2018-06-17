/**
 * Created by KARAN on 19-Oct-17.
 */
import javax.xml.transform.Result;
import java.util.Scanner;
import java.sql.*;
public class driver {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie","root","karan2699");

            int ch;
            Scanner s= new Scanner(System.in);

            while(true)
            {
                System.out.println("%%%%%%% MOVIE DATABASE %%%%%%%");
                System.out.println("1.Insert \n2.Delete \n3.Update\n4.View Table\n5.Exit.");
                System.out.println("-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-/-");
                System.out.println("Choose an option from the main menu : ");
                ch = s.nextInt();
            switch(ch) {
                case 1:
                    System.out.println("Which table you want to insert data? ");
                    System.out.println("1.Movie \n2.Actor\n3.Director\n4.Production House\n5.Singer\n6.Songs\n7.Cameo\n8.Acts\n9.Genres\n10.User ");
                    ch = s.nextInt();
                    switch (ch) {
                        case 1:
                            PreparedStatement stmt1 = myConn.prepareStatement("insert into movies values (?,?,?,?,?,?,?,?)");
                            PreparedStatement stt = myConn.prepareStatement("insert into genre values (?,?)");
                            System.out.println("Enter Title :");
                            s.nextLine();
                            String h =s.nextLine();
                            stmt1.setString(1,h);
                            stt.setString(1,h);
                            System.out.println("Enter Year of Release  : ");
                            stmt1.setInt(2,s.nextInt());
                            System.out.println("Enter Duration(in length) :");
                            stmt1.setInt(3,s.nextInt());
                            System.out.println("Enter Rating : ");
                            stmt1.setFloat(4,s.nextFloat());
                            System.out.println("Enter Genre: ");
                            stt.setString(2,s.next());
                            System.out.println("Enter Quotes: ");
                            s.nextLine();
                            stmt1.setString(5,s.nextLine());
                            System.out.println("Enter Director Name: ");
                            stmt1.setString(8,s.nextLine());
                            System.out.println("Enter Singer Name: ");
                            stmt1.setString(9,s.nextLine());
                            System.out.println("Enter Production House: ");
                            stmt1.setString(10,s.nextLine());
                            stmt1.executeUpdate();
                            stt.executeUpdate();

                            break;
                        case 2:
                            PreparedStatement stmt = myConn.prepareStatement("insert into actor values(?,?,?,?,?)");
                            System.out.println("Enter user_id");
                            stmt.setString(1,s.next());
                            System.out.println("Enter actor name : ");
                            s.nextLine();
                            stmt.setString(2,s.nextLine());
                            System.out.println("Enter DOB(DD-MM-YYYY) :");
                            stmt.setString(3,s.next());
                            System.out.println("Enter Gender : ");
                            stmt.setString(4,s.next());
                            System.out.println("Enter pay : ");
                            stmt.setLong(5,s.nextLong());
                            stmt.executeUpdate();
                            break;

                        case 3:
                            PreparedStatement stmt3 = myConn.prepareStatement("insert into director values(?,?,?,?)");
                            System.out.println("Enter user_id");
                            stmt3.setString(1,s.next());
                            System.out.println("Enter director name : ");
                            s.nextLine();
                            stmt3.setString(2,s.nextLine());
                            System.out.println("Enter DOB(DD-MM-YYYY) :");
                            stmt3.setString(3,s.next());
                            System.out.println("Enter No of Movies : ");
                            stmt3.setInt(4,s.nextInt());
                            stmt3.executeUpdate();
                            break;

                        case 4:
                            PreparedStatement stmt4 = myConn.prepareStatement("insert into production_house values(?,?,?)");
                            System.out.println("Enter name");
                            s.nextLine();
                            stmt4.setString(1,s.nextLine());
                            System.out.println("Enter owner's name : ");
                            s.nextLine();
                            stmt4.setString(2,s.nextLine());
                            System.out.println("Enter Address :");
                            stmt4.setString(3,s.nextLine());
                            stmt4.executeUpdate();
                            break;

                        case 6:
                            PreparedStatement stmt5 = myConn.prepareStatement("insert into songs values(?,?,?,?)");
                            System.out.println("Enter Title : ");
                            s.nextLine();
                            stmt5.setString(1,s.nextLine());
                            System.out.println("Enter Duration(in minutes) : ");
                            stmt5.setInt(2,s.nextInt());
                            System.out.println("Enter Singer :");
                            s.nextLine();
                            stmt5.setString(3,s.nextLine());
                            System.out.println("Enter Movie :");
                            s.nextLine();
                            stmt5.setString(4,s.nextLine());
                            stmt5.executeUpdate();
                            break;
                        case 5:
                            PreparedStatement stmt6 = myConn.prepareStatement("insert into singer values(?,?,?,?)");
                            System.out.println("Enter Name : ");
                            s.nextLine();
                            stmt6.setString(1,s.nextLine());
                            System.out.println("Enter DOB(DD-MM-YYYY) : ");
                            stmt6.setString(2,s.next());
                            System.out.println("Enter Genre :");
                            s.nextLine();
                            stmt6.setString(3,s.nextLine());
                            System.out.println("Enter USer_id :");
                            stmt6.setString(4,s.next());
                            stmt6.executeUpdate();
                            break;

                        case 7:
                            PreparedStatement stmt7 = myConn.prepareStatement("insert into cameo values(?,?,?,?)");
                            System.out.println("Enter Cameo Artist Name : ");
                            s.nextLine();
                            stmt7.setString(1,s.nextLine());
                            System.out.println("Enter Role Of the Artist : ");
                            stmt7.setString(2,s.nextLine());
                            System.out.println("Enter DOB(DD-MM-YYYY) : ");
                            stmt7.setString(3,s.next());
                            System.out.println("Enter Movie Name : ");
                            s.nextLine();
                            stmt7.setString(4,s.nextLine());
                            stmt7.executeUpdate();
                            break;
                        case 8:
                            PreparedStatement stmt8 = myConn.prepareStatement("insert into acts values(?,?)");
                            System.out.println("Enter Movie Name : ");
                            s.nextLine();
                            stmt8.setString(1,s.nextLine());
                            System.out.println("Enter Actor Name : ");
                            stmt8.setString(2,s.nextLine());
                            stmt8.executeUpdate();
                            break;
                        case 9:
                            PreparedStatement stmt9 = myConn.prepareStatement("insert genre acts values(?,?)");
                            System.out.println("Enter Movie Name : ");
                            s.nextLine();
                            stmt9.setString(1,s.nextLine());
                            System.out.println("Enter Genre : ");
                            stmt9.setString(2,s.nextLine());
                            stmt9.executeUpdate();
                            break;
                        case 10:
                            PreparedStatement stmt10 = myConn.prepareStatement("insert user acts values(?,?)");
                            System.out.println("Enter user_id : ");
                            s.nextLine();
                            stmt10.setString(1,s.nextLine());
                            System.out.println("Enter user's Name : ");
                            stmt10.setString(2,s.nextLine());
                            stmt10.executeUpdate();
                            break;
                        default:
                            System.out.println("Wrong Choice !");break;
                    }
                    break;
                case 2:
                    System.out.println("Which table you want to delete data? ");
                    System.out.println("1.Movie \n2.Actor\n3.Director\n4.Production House\n5.Singer\n6.Songs\n7.Cameo\n8.Acts\n9.Genres\n10.User  ");
                    ch = s.nextInt();
                    switch (ch)
                    {
                        case 1:
                            System.out.println("Which Movie's data you want to delete ?");
                            PreparedStatement s1 = myConn.prepareStatement("delete from movies where Title=? ");
                            System.out.println("Enter title : ");
                            s.nextLine();
                            s1.setString(1,s.nextLine());
                            s1.executeUpdate();
                            break;
                        case 2:
                            System.out.println("Which Actor's data you want to delete ?");
                            PreparedStatement s2 = myConn.prepareStatement("delete from actor where NAme=? ");
                            System.out.println("Enter actor name : ");
                            s.nextLine();
                            s2.setString(1,s.nextLine());
                            s2.executeUpdate();
                            break;
                        case 3:
                            System.out.println("Which Director's data you want to delete ?");
                            PreparedStatement s3 = myConn.prepareStatement("delete from director where User_id =? and Name=?");
                            System.out.println("Enter User_Id : ");
                            s3.setString(1,s.next());
                            System.out.println("Enter Name : ");
                            s.nextLine();
                            s3.setString(2,s.nextLine());
                            s3.executeUpdate();
                            break;
                        case 4:
                            System.out.println("Which Production House's data you want to delete ?");
                            PreparedStatement s4 = myConn.prepareStatement("delete from production_house where Name=? and Address =?");
                            System.out.println("Enter Name : ");
                            s.nextLine();
                            s4.setString(1,s.nextLine());
                            System.out.println("Enter Address : ");
                            s4.setString(2,s.nextLine());
                            s4.executeUpdate();
                            break;
                        case 5:
                            System.out.println("Which Singer's data you want to delete ?");
                            PreparedStatement s5 = myConn.prepareStatement("delete from Singer where Name=? and User_id =?");
                            System.out.println("Enter Name : ");
                            s.nextLine();
                            s5.setString(1,s.nextLine());
                            System.out.println("Enter User_id : ");
                            s5.setString(2,s.nextLine());
                            s5.executeUpdate();
                            break;
                        case 6:
                            System.out.println("Which Song's data you want to delete ?");
                            PreparedStatement s6 = myConn.prepareStatement("delete from Songs where Title =?");
                            System.out.println("Enter Title : ");
                            s.nextLine();
                            s6.setString(1,s.nextLine());
                            s6.executeUpdate();
                            break;
                        case 7:
                            System.out.println("Which Cameo Artist's data you want to delete ?");
                            PreparedStatement s7 = myConn.prepareStatement("delete from Cameo where Movie_Name =?");
                            System.out.println("Enter Movie Name : ");
                            s.nextLine();
                            s7.setString(1,s.nextLine());
                            s7.executeUpdate();
                            break;
                        case 8:
                            System.out.println("Which movie's 'Acts' relation's data you want to delete ?");
                            PreparedStatement s8 = myConn.prepareStatement("delete from acts where movie=? and actor=?");
                            System.out.println("Enter Movie : ");
                            s8.setString(1,s.next());
                            System.out.println("Enter Actor : ");
                            s.nextLine();
                            s8.setString(2,s.nextLine());
                            s8.executeUpdate();
                            break;
                        case 9:
                            System.out.println("Which Movie's genre data you want to delete ?");
                            PreparedStatement s9 = myConn.prepareStatement("delete from genre where movie =? ");
                            System.out.println("Enter movie : ");
                            s9.setString(1,s.next());
                            s9.executeUpdate();
                            break;
                        case 10:
                            System.out.println("Which user's data you want to delete ?");
                            PreparedStatement s10 = myConn.prepareStatement("delete from user where User_id =? and Name=?");
                            System.out.println("Enter User_Id : ");
                            s10.setString(1,s.next());
                            System.out.println("Enter Name : ");
                            s.nextLine();
                            s10.setString(2,s.nextLine());
                            s10.executeUpdate();
                            break;
                        default:
                            System.out.println("Wrong choice!");break;
                    }
                    break;
                case 3 :
                    System.out.println("Which table you want to update data? ");
                    System.out.println("1.Movie \n2.Actor\n3.Director\n4.Songs.");
                    ch=s.nextInt();
                    switch(ch)
                    {
                        case 1 :
                            System.out.println("Enter Movie Name you want to update data : ");
                            PreparedStatement stat1 = myConn.prepareStatement("update movies set Quote =? , Rating = ? , Year_of_release = ? where Title =?");
                            s.nextLine();
                            stat1.setString(4,s.nextLine());
                            System.out.println("Enter Quote : ");
                            stat1.setString(1,s.nextLine());
                            System.out.println("Enter Rating : ");
                            stat1.setInt(2,s.nextInt());
                            System.out.println("Enter Year of Release : ");
                            stat1.setInt(3,s.nextInt());
                            stat1.executeUpdate();
                            break;
                        case 2 :
                            System.out.println("Enter user_id and name of actor you want to update data : ");
                            PreparedStatement stat2 = myConn.prepareStatement("update actor set pay =? where user_id=? and name =?");
                            stat2.setString(2,s.next());
                            stat2.setString(3,s.next());
                            System.out.println("Enter pay : ");
                            stat2.setInt(1,s.nextInt());
                            stat2.executeUpdate();
                            break;

                        case 3 :
                            System.out.println("Enter user_id and name of director you want to update data : ");
                            PreparedStatement stat3 = myConn.prepareStatement("update director set No_of_movies =? where User_id=? and Name =?");
                            stat3.setString(2,s.next());
                            s.nextLine();
                            stat3.setString(3,s.nextLine());
                            System.out.println("Enter No of Movies : ");
                            stat3.setInt(1,s.nextInt());
                            stat3.executeUpdate();
                            break;

                        case 4:
                            System.out.println("Enter title of the song you want to update data : ");
                            PreparedStatement stat4 = myConn.prepareStatement("update songs Length (in mins)  =? where Title =?");
                            s.nextLine();
                            stat4.setString(2,s.nextLine());
                            System.out.println("Enter the Corrected Length(in mins): ");
                            stat4.setInt(1,s.nextInt());
                            stat4.executeUpdate();
                            break;

                        default:
                            System.out.println("Wrong Choice !");
                    }
                    break;

                case 4:
                    System.out.println("Which table's data you want to view?");
                    System.out.println("1.Movie \n2.Actor\n3.Director\n4.Production House\n5.Singer\n6.Songs\n7.Cameo\n8.Acts\n9.Genres\n10.User  ");
                    ch=s.nextInt();
                    switch(ch)
                    {
                        case 1 :
                            Statement st1 = myConn.createStatement();
                            ResultSet rs1 = st1.executeQuery("select * from movies");
                            System.out.format("%20s%20s%10s%10s%25s%20s%20s%20s","Title","Release Yr.","Length","Rating","Quote","Director","Singer","Production House");
                            System.out.println("");
                            while(rs1.next())
                            {
                                System.out.format("%20s%20s%10s%10s%25s%20s%20s%20s",rs1.getString("Title"),rs1.getString("Year_of_release"),rs1.getString("Length(in mins)"),rs1.getString("Rating"),rs1.getString("Quote"),rs1.getString("Director"),rs1.getString("Singer"),rs1.getString("ProductionHouse"));
                                System.out.println("");
                            }
                            break;
                        case 2 :
                            Statement st2 = myConn.createStatement();
                            ResultSet rs2=st2.executeQuery("select * from actor ");
                            System.out.format("%10s%20s%15s%8s%10s","User_id","Name","DOB","Gender","Pay");
                            System.out.println("");
                            while(rs2.next())
                            {
                                System.out.format("%10s%20s%15s%8s%10s",rs2.getString("user_id"),rs2.getString("NAme"),rs2.getString("DOB"),rs2.getString("Gender"),rs2.getString("Pay")+"\n");
                            }
                            System.out.println("");
                            break;
                        case 3:
                            Statement st3 = myConn.createStatement();
                            ResultSet rs3 = st3.executeQuery("select * from director");
                            System.out.format("%10s%20s%15s%15s","User_id","Name","DOB","No. of movies" + "\n");
                            while (rs3.next()) {
                                System.out.format("%10s%20s%15s%15s",rs3.getString("user_id"),rs3.getString("Name"),rs3.getString("DOB"),rs3.getString("No_of_movies")+"\n");
                            }
                            break;
                        case 4 :
                            Statement st4 = myConn.createStatement();
                            ResultSet  rs4 = st4.executeQuery("select * from production_house");
                            System.out.format("%20s%20s%30s","Name","Owner's Name","Address"+'\n');
                            while(rs4.next())
                            {
                                System.out.format("%20s%20s%30s",rs4.getString("Name"),rs4.getString("Owner's_name"),rs4.getString("Address"+'\n'));
                            }
                            break;

                        case 5 :
                            Statement st5 = myConn.createStatement();
                            ResultSet  rs5 = st5.executeQuery("select * from singer");
                            System.out.format("%20s%20s%20s%20s","Name","DOB","Genre","User_id"+'\n');
                            while(rs5.next())
                            {
                                System.out.format("%20s%20s%20s",rs5.getString("User_id"),rs5.getString("Name"),rs5.getString("DOB"),rs5.getString("Genre"+'\n'));
                            }
                            break;


                        case 6 :
                            Statement st6 = myConn.createStatement();
                            ResultSet  rs6 = st6.executeQuery("select * from songs");
                            System.out.format("%20s%10s%20s%20s","Title","Length","Singer","Movie"+'\n');
                            while(rs6.next())
                            {
                                System.out.format("%20s%10s%20s%20s",rs6.getString("Title"),rs6.getString("Length (in mins)"),rs6.getString("Singer"),rs6.getString("Movie")+'\n');
                            }
                            break;


                        case 7:
                            Statement st7 = myConn.createStatement();
                            ResultSet rs7 = st7.executeQuery("select * from Cameo");
                            System.out.format("%20s%20s%20s%20s","Name","Role","DOB","Movie"+'\n');
                            while (rs7.next()) {
                                System.out.format("%20s%20s%20s%20s",rs7.getString("Name"),rs7.getString("Role"),rs7.getString("DOB"),rs7.getString("Movie")+'\n');
                            }
                            break;
                        case 8:
                            Statement st8 = myConn.createStatement();
                            ResultSet rs8 = st8.executeQuery("select * from acts");
                            System.out.format("%30s%30s","Movie","Actor"+'\n');
                            while (rs8.next()) {
                                System.out.format("%30s%30s",rs8.getString("Movie"),rs8.getString("Actor")+'\n');
                            }
                            break;
                        case 9:
                            Statement st9 = myConn.createStatement();
                            ResultSet rs9 = st9.executeQuery("select * from genre");
                            System.out.format("%30s%30s","Movie","Genre"+'\n');
                            while (rs9.next()) {
                                System.out.format("%30s%30s",rs9.getString("Movie"),rs9.getString("Genre")+'\n');
                            }
                            break;
                        case 10:
                            Statement st10 = myConn.createStatement();
                            ResultSet rs10 = st10.executeQuery("select * from user");
                            System.out.format("%30s%30s","User_id","Name"+'\n');
                            while (rs10.next()) {
                                System.out.format("%30s%30s",rs10.getString("User_id"),rs10.getString("Name")+'\n');
                            }
                            break;
                        default:
                            System.out.println("Wrong Choice !");break;


                    }
                    break;

                case 5:
                    System.out.println("Bye!");
                    return ;
                default:
                    System.out.println("Wrong Choice !");break;
            }
        }
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }

    }
}
