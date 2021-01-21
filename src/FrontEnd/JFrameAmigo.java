/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.*; 
import java.util.ArrayList;

/**
 *
 * @author guilh
 */
public class JFrameAmigo extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrameAmigo
     */
    public JFrameAmigo(Aluno aluno, Aluno amigo) {
        this.amigo = amigo; 
        this.aluno = aluno;
        this.cont = 0;
        initComponents();
        
        this.setTitle("Perfil " + amigo.getNome());
        String out = amigo.visualizarInfo(aluno);
    
        jTextAreaInfo.setText(out); 
        
        out = amigo.visualizarTurma(aluno);
        
        jTextAreaTurmas.setText(out);
        jTextField1.setVisible(false);
        
        criaListaAmigos();
        
        if(aluno.getAmigos().contains(amigo)){
            jButtonAdicionar.setVisible(false);
        }
        
    }
    
    private void criaListaAmigos() {
        if (amigo.getAmigos().size() != 0 && aluno.getPermissao().getChave() == 1) {
            String[] listaAmigos = new String[amigo.getAmigos().size()];
            int i = 0; 
            for(Usuario amigo:amigo.getAmigos()) {
                listaAmigos[i] = amigo.getNome(); 
                i++; 
            }
            JListAmigos.setListData(listaAmigos);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelAmigo = new javax.swing.JPanel();
        jButtonMensagem = new javax.swing.JButton();
        jButtonAdicionar = new javax.swing.JButton();
        jTextAreaInfo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        JListAmigos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaTurmas = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanelAmigo.setBackground(java.awt.Color.white);

        jButtonMensagem.setBackground(new java.awt.Color(176, 31, 50));
        jButtonMensagem.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonMensagem.setForeground(java.awt.Color.white);
        jButtonMensagem.setText("Enviar Mensagem");
        jButtonMensagem.setOpaque(true);
        jButtonMensagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMensagemActionPerformed(evt);
            }
        });

        jButtonAdicionar.setBackground(new java.awt.Color(176, 31, 50));
        jButtonAdicionar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonAdicionar.setForeground(java.awt.Color.white);
        jButtonAdicionar.setText("Adicionar Amigo");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        jTextAreaInfo.setEditable(false);
        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("INFO"));

        JListAmigos.setBorder(javax.swing.BorderFactory.createTitledBorder("AMIGOS"));
        JListAmigos.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        JListAmigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não tem permissão para visualização" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        JListAmigos.setToolTipText("");
        JListAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JListAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(JListAmigos);

        jTextAreaTurmas.setEditable(false);
        jTextAreaTurmas.setColumns(20);
        jTextAreaTurmas.setRows(5);
        jTextAreaTurmas.setBorder(javax.swing.BorderFactory.createTitledBorder("TURMAS"));
        jScrollPane2.setViewportView(jTextAreaTurmas);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Ubuntu", 0, 10)); // NOI18N
        jTextField1.setForeground(java.awt.Color.red);
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAmigoLayout = new javax.swing.GroupLayout(jPanelAmigo);
        jPanelAmigo.setLayout(jPanelAmigoLayout);
        jPanelAmigoLayout.setHorizontalGroup(
            jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAmigoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextAreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAmigoLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAmigoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButtonAdicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonMensagem, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(71, 71, 71))))
        );
        jPanelAmigoLayout.setVerticalGroup(
            jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelAmigoLayout.createSequentialGroup()
                .addGroup(jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAmigoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextAreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanelAmigoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButtonMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)))
                .addGroup(jPanelAmigoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAmigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelAmigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JListAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JListAmigosMouseClicked
        if (evt.getClickCount() == 2 && amigo.getAmigos().size() != 0) {
            int index = JListAmigos.getSelectedIndex();
            Usuario colega = amigo.getAmigos().get(index);
            if(colega != aluno){
                JFrameAmigo frameAmigo = new JFrameAmigo(amigo, (Aluno)colega);
                frameAmigo.setVisible(true);
            }
        }
    }//GEN-LAST:event_JListAmigosMouseClicked

    private void jButtonMensagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMensagemActionPerformed
        // TODO add your handling code here:
        boolean verif = false;
        Conversa conversa = null;
        
        for(Conversa c:aluno.getConversas()){
            
            // Verifica se ja nao existe uma conversa entre os usuarios
            if(c.getPessoas().getGrupo().contains(aluno) && c.getPessoas().getGrupo().contains(amigo) 
               && c.getPessoas().getGrupo().size() == 2){
                verif = true;
                conversa = c;

            }
        }
        
        if(!verif){
            ArrayList<Usuario> grupo = new ArrayList<Usuario>();
            grupo.add(aluno); grupo.add(amigo);
            conversa = aluno.iniciarConversa(grupo);
        }
        
        JFrameMensagem frameMensagem = new JFrameMensagem(conversa, aluno);
        frameMensagem.setVisible(true);
    }//GEN-LAST:event_jButtonMensagemActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        // TODO add your handling code here:       
        if(cont == 0){
            aluno.adicionarSolicitacao(amigo);
            jTextField1.setVisible(true);
            jTextField1.setText("Solicitação enviada!");
        }
        else{
            jTextField1.setVisible(true);
            jTextField1.setText("Solicitação já enviada!");
        }
    }//GEN-LAST:event_jButtonAdicionarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> JListAmigos;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JButton jButtonMensagem;
    private javax.swing.JPanel jPanelAmigo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaInfo;
    private javax.swing.JTextArea jTextAreaTurmas;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    private Aluno amigo; 
    private Aluno aluno;
    private int cont;
}
