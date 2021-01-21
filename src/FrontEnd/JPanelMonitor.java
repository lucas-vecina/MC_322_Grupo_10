/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.*;

/**
 *
 * @author guilh
 */
public class JPanelMonitor extends javax.swing.JPanel {

    /**
     * Creates new form JPanelMonitoria
     */
    public JPanelMonitor(Monitoria monitoria) {
        initComponents();
        this.monitoria = monitoria; 
        criaChat(); 
        criaListaAlunos(); 
        if(monitoria.isStatus()) {
            jButtonAbrir.setVisible(false); 
        }
        else
            jButtonFechar.setVisible(false); 
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
        jButtonAbrir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneChat = new javax.swing.JTextPane();
        jTextFieldResposta = new javax.swing.JTextField();
        jButtonResponder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFila = new javax.swing.JList<>();
        jButtonAtender = new javax.swing.JButton();
        jButtonFechar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonAbrir.setBackground(new java.awt.Color(201, 23, 48));
        jButtonAbrir.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonAbrir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAbrir.setText("Abrir");
        jButtonAbrir.setBorder(null);
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });

        jTextPaneChat.setEditable(false);
        jTextPaneChat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chat", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jTextPaneChat.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jScrollPane1.setViewportView(jTextPaneChat);

        jTextFieldResposta.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N

        jButtonResponder.setBackground(new java.awt.Color(201, 23, 48));
        jButtonResponder.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonResponder.setForeground(new java.awt.Color(255, 255, 255));
        jButtonResponder.setText("Responder");
        jButtonResponder.setBorder(null);
        jButtonResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResponderActionPerformed(evt);
            }
        });

        jListFila.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos na fila", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListFila.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListFila.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Não há pessoas na fila." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListFila.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListFilaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListFila);

        jButtonAtender.setBackground(new java.awt.Color(201, 23, 48));
        jButtonAtender.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonAtender.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAtender.setText("Atender");
        jButtonAtender.setBorder(null);
        jButtonAtender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtenderActionPerformed(evt);
            }
        });

        jButtonFechar.setBackground(new java.awt.Color(201, 23, 48));
        jButtonFechar.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonFechar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFechar.setText("Fechar");
        jButtonFechar.setBorder(null);
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAtender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtenderActionPerformed
        // TODO add your handling code here:
        monitoria.atender(monitoria.getMonitor());
        criaListaAlunos();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButtonAtenderActionPerformed

    private void jListFilaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListFilaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() == 2 && monitoria.getFila().size() != 0) {
            int index = jListFila.getSelectedIndex();
            Usuario aluno = monitoria.getFila().get(index); 
            JFrameAmigo frameAmigo = new JFrameAmigo(monitoria.getMonitor(), (Aluno)aluno); 
            frameAmigo.setVisible(true);
        }
    }//GEN-LAST:event_jListFilaMouseClicked

    private void jButtonResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResponderActionPerformed
        // TODO add your handling code here:
        String out = jTextFieldResposta.getText();
        jTextFieldResposta.setText("");
        monitoria.getConversa().enviarMensagem(monitoria.getMonitor(), out);
        criaChat(); 
        this.revalidate();
        this.repaint(); 
    }//GEN-LAST:event_jButtonResponderActionPerformed

    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed
        // TODO add your handling code here:
        monitoria.abrirMonitoria(monitoria.getMonitor());
        jButtonAbrir.setVisible(false);
        jButtonFechar.setVisible(true);
        this.revalidate();
        this.repaint(); 
    }//GEN-LAST:event_jButtonAbrirActionPerformed

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
        // TODO add your handling code here:
        monitoria.fecharMonitoria(monitoria.getMonitor());
        jButtonFechar.setVisible(false);
        jButtonAbrir.setVisible(true);
        criaListaAlunos();
        criaChat(); 
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void criaChat() {
        if(monitoria.getConversa().getMensagens().size() != 0) {
            String out = ""; 
            for(Mensagem mensagem:monitoria.getConversa().getMensagens()) {
                if (mensagem.getSujeito() == monitoria.getMonitor())
                out += "Você: ";
                else
                    out += mensagem.getSujeito().getNome() + ": ";
                out += mensagem.getTexto();
                if (monitoria.getConversa().getMensagens().indexOf(mensagem) != monitoria.getConversa().getMensagens().size()-1) {
                    out += "\n";
                }
            }
            jTextPaneChat.setText(out);
        }
        else {
            jTextPaneChat.setText("");
        }
    }
        
    private void criaListaAlunos() {
        if(monitoria.getFila().size() != 0) {
            String[] listaAlunos = new String[monitoria.getFila().size()];
            int i = 0;
            for(Aluno aluno:monitoria.getFila()) {
                listaAlunos[i] = aluno.getNome() + ", RA: " + aluno.getRa(); 
                i++; 
            }
            jListFila.setListData(listaAlunos);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonAtender;
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JButton jButtonResponder;
    private javax.swing.JList<String> jListFila;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldResposta;
    private javax.swing.JTextPane jTextPaneChat;
    // End of variables declaration//GEN-END:variables
    Monitoria monitoria;
}
