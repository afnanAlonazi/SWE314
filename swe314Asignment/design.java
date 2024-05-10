package swe314Asignment;



import javax.swing.JOptionPane;

import swe314Asignment.Encryptor;
import swe314Asignment.design;
public class design extends javax.swing.JFrame {



    
    public design() {
        initComponents();
        this.setSize(1100, 600);
    }

   
    @SuppressWarnings("unchecked")
   
    
   
   
 
    private javax.swing.JButton encryption ,decryption ,S2RButton;
    private javax.swing.Box.Filler filler1;

  
    private javax.swing.JLabel genraltitle ,image,keyText ,SenderText,RecieverText ,ciphertext ,msgText, msgText3 ,msgText2;
    private javax.swing.JTextField msgField ,keyField ,msgField2 ,ciphertextA;
 

 
    private javax.swing.JPanel jPanel1;
  
   
    private javax.swing.JLabel plaintext;
    private javax.swing.JLabel plaintextA;
    
    private void initComponents() {
    
        genraltitle = new javax.swing.JLabel();
     
        keyText = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 100), new java.awt.Dimension(0, 100), new java.awt.Dimension(32767, 100));
        
        ciphertextA =new javax.swing.JTextField();
       
        ciphertext = new javax.swing.JLabel();
       
        msgField = new javax.swing.JTextField();
        msgField2 = new javax.swing.JTextField();
        keyField = new javax.swing.JTextField();
        encryption = new javax.swing.JButton();
        msgText = new javax.swing.JLabel();
        msgText3 = new javax.swing.JLabel();
        plaintextA = new javax.swing.JLabel();
        decryption = new javax.swing.JButton();
       
        plaintext = new javax.swing.JLabel();
        
       
        msgText2 = new javax.swing.JLabel();
  
        jPanel1 = new javax.swing.JPanel();
        RecieverText = new javax.swing.JLabel();
        SenderText = new javax.swing.JLabel();
       
        image = new javax.swing.JLabel();
        S2RButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        genraltitle.setFont(new java.awt.Font("Tahoma", 0, 21)); // 
        genraltitle.setText("AES Algorithem");
        getContentPane().add(genraltitle);
        genraltitle.setBounds(350, 80, 197, 29);
        getContentPane().add(filler1);
        filler1.setBounds(675, 77, 0, 457);

        keyText.setFont(new java.awt.Font("Tahoma", 0, 14)); // 
        keyText.setText("Enter Key-16 characters:");
        getContentPane().add(keyText);
        keyText.setBounds(340, 180, 400, 22);

        ciphertextA.setFont(new java.awt.Font("Tahoma", 0, 13)); // 
        ciphertextA.setText("Result ");
        getContentPane().add(ciphertextA);
        ciphertextA.setBounds(250, 451, 400, 35);
        getContentPane().add(msgField);
        msgField.setBounds(250, 286, 350, 35);
        getContentPane().add(keyField);
        keyField.setBounds(250, 200, 350, 35);
       
        encryption.setBackground(new java.awt.Color(116, 163, 178));
        encryption.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        encryption.setText("Encryption");
        encryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionActionPerformed(evt);
            }
        }
        
        		);
        getContentPane().add(encryption);
        encryption.setBounds(280, 362, 139, 49);

        msgText.setFont(new java.awt.Font("Tahoma", 10, 14)); // NOI18N
        msgText.setText("Enter a message to");
        getContentPane().add(msgText);
        msgText.setBounds(340, 240, 400, 22);
        msgText3.setFont(new java.awt.Font("Tahoma", 10, 14)); // NOI18N
        msgText3.setText("encrypt(16 characters) or decrypt .");
        getContentPane().add(msgText3);
        msgText3.setBounds(300, 260, 400, 22);

        decryption.setBackground(new java.awt.Color(116, 163, 178));
        decryption.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        decryption.setText("Decryption");
        decryption.setAutoscrolls(true);
        decryption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptionActionPerformed(evt);
            }
        });
        getContentPane().add(decryption);
        decryption.setBounds(456, 362, 139, 49);

  

        getContentPane().add(jPanel1);
        jPanel1.setBounds(325, 35, 16, 510);

        image.setBackground(new java.awt.Color(51, 0, 153));
        image.setForeground(new java.awt.Color(204, 0, 102));
        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/swe314Asignment/encryption.png"))); 
        getContentPane().add(image);
        image.setBounds(670, 0, 310, 640);

        pack();
    }// 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   

    private void encryptionActionPerformed(java.awt.event.ActionEvent evt) {
    
    	Encryptor encryptor = new Encryptor();
    		if(!encryptor. isValidInput_key_plain(keyField.getText()) ||  !encryptor. isValidInput_key_plain(msgField.getText()))
    		{
    		JOptionPane.showMessageDialog(null, "invalid input");	
    		keyField.setText("");
    		msgField.setText("");	
    		ciphertextA.setText("");
    			
    		} else {
    			
    			try {
    				 byte[] key = encryptor.stringToByteArray(keyField.getText());
    			    	
    	  ciphertextA.setText(encryptor.encrypt(msgField.getText(),key ));
    	}catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "invalid input try again");
    		keyField.setText("");
    		msgField.setText("");
    		ciphertextA.setText("");
    	}
    	
    }
    }
    private void decryptionActionPerformed(java.awt.event.ActionEvent evt) {
    	Encryptor encryptor2 = new Encryptor();
		if(!encryptor2. isValidInput_key_plain(keyField.getText()) )
		{
		JOptionPane.showMessageDialog(null, "invalid input");	
		keyField.setText("");
		msgField.setText("");	
		ciphertextA.setText("");	
			
		} else {
			
    	 try {
    		 byte[] key = encryptor2.stringToByteArray(keyField.getText());
    		 ciphertextA.setText( encryptor2.decrypt(msgField.getText(),key));
    	
    		}catch(Exception e) {
    			JOptionPane.showMessageDialog(null, "invalid input try again");
    			keyField.setText("");
        		msgField.setText("");
        		ciphertextA.setText("");
        	}
		}
    	 
    	 
     

    }

   
  
    

   

  ///////////////////////////////////////////////////////////////////////////
    public static void main(String args[]) {
   

        
    	  new design().setVisible(true);
      
    }

}
