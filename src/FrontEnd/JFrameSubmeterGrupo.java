/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.*; 
import java.util.ArrayList; 
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JFrameSubmeterGrupo extends javax.swing.JFrame {

    /**
     * Creates new form JFrameSubtmeterGrupo
     */
    public JFrameSubmeterGrupo(AtividadeGrupo atividade, Aluno aluno, String arquivo) {
        initComponents();
        setTitle("Adicionar pessoas ao grupo"); 
        this.atividade = atividade;
        this.aluno = aluno;  
        alunos = new ArrayList<Aluno>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAlunosGrupo = new javax.swing.JList<>();
        jTextFieldUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldRa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonRemover = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jListAlunosGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos no grupo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListAlunosGrupo.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListAlunosGrupo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Adicione alunos." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListAlunosGrupo);

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jLabel1.setText("Nome");

        jTextFieldRa.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jLabel2.setText("RA");

        jButtonRemover.setBackground(new java.awt.Color(201, 23, 48));
        jButtonRemover.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonRemover.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRemover.setText("Remover");
        jButtonRemover.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverActionPerformed(evt);
            }
        });

        jButtonAdicionar.setBackground(new java.awt.Color(201, 23, 48));
        jButtonAdicionar.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(201, 23, 48));
        jButton1.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Submeter");
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldUser)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldRa)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jButtonAdicionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldRa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonAdicionar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:
        if(!jTextFieldUser.getText().equals("") && !jTextFieldRa.getText().equals("")) {
            boolean achou = false;
            for(Usuario aluno:Usuario.getUsuarios()) {
                if((aluno instanceof Aluno) && aluno.getNome().equals(jTextFieldUser.getText()) && ((Aluno)aluno).getRa().equals(jTextFieldRa.getText())) {
                    achou = true;
                    alunos.add((Aluno)aluno);
                    break;
                }
            }
            if(!achou) {
                JOptionPane.showMessageDialog(null, "Nome e/ou RA não encontrado.");
            }
            else {
                criaListaAlunos();
                jPanel1.revalidate();
                jPanel1.repaint(); 
            }
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverActionPerformed
        // TODO add your handling code here:
        if(!alunos.isEmpty()) {
            int index = jListAlunosGrupo.getSelectedIndex();
            alunos.remove(index);
            criaListaAlunos();
            jPanel1.revalidate();
            jPanel1.repaint(); 
        }
    }//GEN-LAST:event_jButtonRemoverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ArrayList<Usuario> equipe = new ArrayList<Usuario>(alunos); 
        equipe.add(aluno);
        Grupo grupo = new Grupo(equipe);
        String resposta = atividade.adicionarGrupo(grupo); 
        switch (resposta) {
            case "1":
                JOptionPane.showMessageDialog(null, "Grupo nao pode ser adicionado. Um ou mais alunos nao pertencem a essa turma.");
                break;
            case "2":
                JOptionPane.showMessageDialog(null, "Grupo nao pode ser adicionado. um ou mais integrantes ja pertencem a um outro grupo dessa atividade");
                break;
            case "3":
                JOptionPane.showMessageDialog(null, "Grupo nao pode ser adicionado. Quantidade de integrantes diferente da solicitada."); 
                break; 
            case "4":
                atividade.submeterAtividade(null, grupo, arquivo);
                JOptionPane.showMessageDialog(null, "Atividade submetida!");
                break; 
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void criaListaAlunos() {
        if (!alunos.isEmpty()) {
            String[] listaAlunos = new String[alunos.size()]; 
            int i = 0;
            for(Aluno aluno:alunos) {
                listaAlunos[i] = aluno.getNome() + " ,RA: " + aluno.getRa() + "\n"; 
                i++;
            }
            jListAlunosGrupo.setListData(listaAlunos); 
        }
        else {
            String[] listaAlunos = {"Adicione alunos."};
            jListAlunosGrupo.setListData(listaAlunos); 
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListAlunosGrupo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldRa;
    private javax.swing.JTextField jTextFieldUser;
    // End of variables declaration//GEN-END:variables
    ArrayList<Aluno> alunos; 
    Aluno aluno; 
    AtividadeGrupo atividade;
    String arquivo;
}