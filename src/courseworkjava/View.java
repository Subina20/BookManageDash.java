package courseworkjava;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableModel;
public class View {
	ConnectionC db= new ConnectionC();
    public static void main(String[] args) {
        View vm =new View();
        
    }
    View(){
        
        
        JFrame f=new JFrame("Bookstore Inventory Management System");
        JButton btnBack,btnDelete,btnUpdate,btnSell,btnSearch ;
        JLabel lNo,lAb,lSh;
        String column[]= {"Book Number","Book Name","Author Name","Date Published","Cost","Quantity Available"};
         
        lAb = new JLabel("Available Books");
        f.add(lAb);
        lAb.setBounds(400, 30, 300, 100);
        
        String query="Select * from addbooks";
        ConnectionC db= new ConnectionC();
        ArrayList<Books> book= new ArrayList<Books>();
        
        
        
        
        try {
            ResultSet result=  db.connection().executeQuery(query);
            
            
            while(result.next()) {
                String BookName=result.getString("BookName");
                String AuthorName=result.getString("PublisherName");
                String date=result.getString("Date");
                int Cost=Integer.parseInt(result.getString("Cost"));
                int bookNumber=Integer.parseInt(result.getString("BookCode"));
                int Quantity=Integer.parseInt(result.getString("QuantitySold"));
                Books stff =new Books(BookName, AuthorName, date, Cost,bookNumber, Quantity);
                book.add(stff);
                
//               System.out.println(book.get(0).bookNumber);
////              System.out.println("..............");
                
            }
            
            
            
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        lNo = new JLabel("No of books available:"+ book.size());
        f.add(lNo);
        lNo.setBounds(50, 360, 300, 100);
        
        Object data[][]= new Object[book.size()] [column.length];
        
        for(int i=0; i<book.size(); i++) {
            data[i][0]=book.get(i).bookNumber;
            data[i][1]=book.get(i).BookName;
            data[i][2]=book.get(i).AuthorName;
            data[i][3]=book.get(i).date;
            data[i][4]=book.get(i).Cost;
            data[i][5]=book.get(i).Quantity;
        }

        
        JTable jt =new JTable(data,column);
        JScrollPane sp=new JScrollPane(jt);
        f.add(sp);
        sp.setBounds(50,100,800,300);
        
        
        //button
        
        btnBack=new JButton("Back");
        f.add(btnBack);
        btnBack.setBounds(10, 10, 70, 30);
        
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Dash();
                f.dispose();
            }
        });
        
        
        btnDelete=new JButton("Delete");
        f.add(btnDelete);
        btnDelete.setBounds(500, 550, 150, 30);
        
        
        btnDelete.addActionListener(e->{
            int row= jt.getSelectedRow();
            if(row>=0) {
            
                TableModel model=jt.getModel();
                 
                 String code=Integer.toString((int)model.getValueAt(row,0));
                 
                 String dquery = "Delete from addbooks WHERE `BookCode` = '"+ code +"'";
                 try {
                    int dresult = db.connection().executeUpdate(dquery);
                    if(dresult>=1) {
                        JOptionPane.showMessageDialog(sp,"Book Deleted");
                        new View();
                        f.dispose();
                    }
                   
                } catch (SQLException e1) {
                    
                    e1.printStackTrace();
                }
                 
            }else {
                JOptionPane.showMessageDialog(sp, "please select row");
            }
                
                
            
        });
        
        
        
        
        
        btnUpdate=new JButton("Update");
        f.add(btnUpdate);
        btnUpdate.setBounds(300, 550, 150, 30);
        
        btnUpdate.addActionListener(e->{
            int row = jt.getSelectedRow();
            if(row>=0) {
                
                JLabel lbName= new JLabel("Book Name");
                f.add(lbName);
               
                lbName.setBounds(10,600,900,30);
                
                JTextField tfbName = new JTextField();
                f.add(tfbName);
                tfbName.setBounds(80, 600, 120,30);
                
                TableModel model = jt.getModel();
                String BookName=(String)model.getValueAt(row,1);
                
                tfbName.setText(BookName);
                
                
                JLabel laName= new JLabel("Publisher Name");
                f.add(laName);
                
                laName.setBounds(210,600,300,30);
                
                JTextField tfaName = new JTextField();
                f.add(tfaName);
                tfaName.setBounds(310, 600, 120,30);
                
                TableModel model1 = jt.getModel();
                String AuthorName=(String)model1.getValueAt(row,2);
                
                tfaName.setText(AuthorName);
                
                JLabel lpDate= new JLabel("Date");
                f.add(lpDate);
            
                lpDate.setBounds(470,600,300,30);
                
                JTextField tfpDate = new JTextField();
                f.add(tfpDate);
                tfpDate.setBounds(530, 600, 150,30);
                
                TableModel model2 = jt.getModel(); 
                
                String date=(String)model2.getValueAt(row,3);
                tfpDate.setText(date);
                System.out.println(date);
                
                JLabel laddBy= new JLabel("Cost");
                f.add(laddBy);
           
                laddBy.setBounds(690,600,300,30);
                
                JTextField tfaddBy = new JTextField();
                f.add(tfaddBy);
                tfaddBy.setBounds(740, 600, 150,30);
                
                TableModel model3 = jt.getModel(); 
                
                String Cost=Integer.toString((int)model3.getValueAt(row,4));
                tfaddBy.setText(Cost);
                
                
                
                
                JButton btnChange = new JButton("Make Change");
                f.add(btnChange);
                btnChange.setBounds(430, 650, 150, 50);
                
                JButton btnCancel = new JButton("Cancel");
                f.add(btnCancel);
                btnCancel.setBounds(430, 720, 150, 50);
               
           
                // update action
                
                btnChange.addActionListener(e3->{
                    
                
                    String tbName = tfbName.getText();
                    String taName= tfaName.getText();
                    String tpDate = tfpDate.getText();
                    String taddBy = tfaddBy.getText();
                    
                    
                    TableModel model4 = jt.getModel(); 
                    String Code=Integer.toString((int)model4.getValueAt(row,0));
                    String BookName1=(String)model4.getValueAt(row, 1);
                    String uquery ="update `addbooks` set `BookName` = '" + tbName + "',`PublisherName` = '" + taName + "', `Cost` = '" + taddBy + "',  `Date` = '"+ tpDate +"' WHERE `BookCode` = '"+ Code +"'";
                    System.out.println(uquery);
                     try {
                        int uresult = db.connection().executeUpdate(uquery);
                        if(uresult>=1 ) {
                            JOptionPane.showMessageDialog(sp,"Book Updated");
                            new View();
                            f.dispose();
                        }
                        
                    } catch (SQLException e1) {
                       
                        e1.printStackTrace();
                    }
    
                  
                });
                
                
                
                //cancel action
                
                btnCancel.addActionListener(e2->{
                    
                    new View();
                    f.dispose();
                    
                });
                
                
                
                
                
                
            }else {
                JOptionPane.showMessageDialog(sp, "selected Row");
            }
            
       
        
        
        
        
        });

        
        
         
        f.setLayout(null);  
        f.setSize(1000,900);
        f.setVisible(true);
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        
    }
    public ResultSet bookAvailable(String Search) throws SQLException {
        String query2= "Select * from addbooks where BookName='"+Search+"'";
        
        ResultSet result = db.connection().executeQuery(query2);
        return result;
}
}

