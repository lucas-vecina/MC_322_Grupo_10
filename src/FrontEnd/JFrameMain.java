/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 *
 * @author guilh
 */
public class JFrameMain extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public JFrameMain() {
        initComponents();
        this.setTitle("EADuca");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelPreto = new javax.swing.JPanel();
        jTextFieldLogin = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabelSenha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelNotification = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));

        jPanelPreto.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanelPretoLayout = new javax.swing.GroupLayout(jPanelPreto);
        jPanelPreto.setLayout(jPanelPretoLayout);
        jPanelPretoLayout.setHorizontalGroup(
            jPanelPretoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 363, Short.MAX_VALUE)
        );
        jPanelPretoLayout.setVerticalGroup(
            jPanelPretoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jTextFieldLogin.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jTextFieldLogin.setText("ciri@yahoo.com");

        jLabelEmail.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jLabelEmail.setText("Email");

        jPasswordField1.setFont(new java.awt.Font("Yu Gothic", 0, 8)); // NOI18N
        jPasswordField1.setText("321senha");
        jPasswordField1.setToolTipText("");

        jLabelSenha.setFont(new java.awt.Font("Yu Gothic", 0, 18)); // NOI18N
        jLabelSenha.setText("Senha");

        jButton1.setBackground(new java.awt.Color(201, 23, 48));
        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Entrar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelNotification.setFont(new java.awt.Font("Yu Gothic", 1, 10)); // NOI18N
        jLabelNotification.setForeground(new java.awt.Color(255, 0, 51));
        jLabelNotification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmail)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSenha))
                .addGap(87, 87, 87))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelPreto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(jPanelMainLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabelNotification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabelNotification, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelMainLayout.createSequentialGroup()
                .addComponent(jPanelPreto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String email = jTextFieldLogin.getText();
        String senha = String.valueOf(jPasswordField1.getPassword()); 
        Usuario usuario = Usuario.signIn(email, senha); 
        if (usuario == null) {
          jLabelNotification.setText("Email ou senha incorretos.");
        }
        else {
            if (usuario instanceof Aluno) {
                JPanelAluno panel = new JPanelAluno((Aluno)usuario, this); 
                jPanelMain.setVisible(false);
                setContentPane(panel);  
          }
            if (usuario instanceof Professor) {
                JPanelProf panel = new JPanelProf((Professor)usuario,this);
                jPanelMain.setVisible(false);
                setContentPane(panel);  
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        ArrayList<Aluno> aux1 = new ArrayList<Aluno>();
		
	// Instancias de professores
	Professor prof1 = new Professor("Geraldo", Genero.NAO_BINARIO, "geraldo@hotmail.com", "senha123");
	Professor prof2 = new Professor("Yennefer", Genero.FEMININO, "yen@gmail.com", "123senha");
	ArrayList<Professor> professores = new ArrayList<Professor>();
	professores.add(prof1);
	professores.add(prof2); 
		
	// Instancias de alunos
	Aluno aluno1 = new Aluno("Ciri", Genero.NAO_BINARIO, "ciri@yahoo.com", "321senha", Permissoes.PUBLIC,
		"Eng. Alimentos", "12345");
	Aluno aluno2 = new Aluno("Dandelion", Genero.MASCULINO, "dan@uol.com", "senha321", Permissoes.DEFAULT,
			"Musica", "54321");
	Aluno aluno3 = new Aluno("Zoltan", Genero.NAO_IDENTIFICADO, "zoltan@dac.unicamp.br", "sen321ha", Permissoes.PRIVATE,
				"Eng. Mecanica", "00012");
        Aluno aluno4 = new Aluno("Triss", Genero.FEMININO, "triss@apple.mail.com", "sen123ha", Permissoes.DEFAULT,
                        "Eng. Quimica", "00044");
        Aluno aluno5 = new Aluno("Fringila", Genero.NAO_BINARIO, "frin@usp.br", "sen000ha", Permissoes.PRIVATE,
                        "Quimica", "00055");
        Aluno aluno6 = new Aluno("Emhyr", Genero.MASCULINO, "emhyr@unesp.br", "senha000", Permissoes.PUBLIC,
                        "Economia", "99666");

        ArrayList<Usuario> usuario = new ArrayList<Usuario>(professores);
        usuario.add(aluno1);
        usuario.add(aluno2);
        usuario.add(aluno3);
        usuario.add(aluno4);
	usuario.add(aluno5);
	usuario.add(aluno6);
        
        //Teste Ciri Amigos
        ArrayList<Usuario> amigos = new ArrayList<Usuario>(); 
        amigos.add(aluno2); 
        aluno1.setAmigos(amigos); 
        
        //Teste Turma
        HashMap<Integer, ArrayList<Integer>> horarios1 = new HashMap<Integer, ArrayList<Integer>>();
        ArrayList<Integer> aux = new ArrayList<Integer>();
	aux.addAll(Arrays.asList(10, 11));
	horarios1.put(1, aux);
        Turma turma1 = prof1.criarTurma("Bruxos I", "BX111", horarios1);
        turma1.setEmenta("Vamos conhecer os bruxos.");
        turma1.adicionaAluno(prof1, aluno6);
        aux1.addAll(Arrays.asList(aluno2, aluno4, aluno6));
        turma1.adicionaAluno(prof1, aux1);
        turma1.adicionaPed(prof1, aluno1);
        turma1.adicionaPad(prof1, aluno3);
        
        //Teste solicitacoes
        aluno3.adicionarSolicitacao(aluno1);
        aluno4.adicionarSolicitacao(aluno1);
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameMain().setVisible(true);
            }
        });
    }
    
    public javax.swing.JPanel getJPanelMain() {
        return jPanelMain; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNotification;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanelPreto;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldLogin;
    // End of variables declaration//GEN-END:variables
}
