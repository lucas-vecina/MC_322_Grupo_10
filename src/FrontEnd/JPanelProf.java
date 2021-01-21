/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;

import BackEnd.*;

/**
 *
 * @author USER
 */
public class JPanelProf extends javax.swing.JPanel {

    /**
     * Creates new form JPanelProf
     */
    public JPanelProf(Professor professor, JFrameMain frameMain) {
        initComponents();
        this.professor = professor;
        this.frameMain = frameMain;
        criaListaTurmas(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButtonCriar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListTurmas = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jButton2.setBackground(new java.awt.Color(201, 23, 48));
        jButton2.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Remover turma");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButtonCriar.setBackground(new java.awt.Color(201, 23, 48));
        jButtonCriar.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonCriar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCriar.setText("Criar Turma");
        jButtonCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCriarActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Turmas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N

        jListTurmas.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListTurmas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não está lecionando nenhuma turma." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTurmasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListTurmas);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addComponent(jButtonCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButtonCriar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void criaListaTurmas() {
        if(professor.getTurmas().size() != 0) {
            String[] listaTurmas = new String[professor.getTurmas().size()]; 
            int i = 0; 
            for(Turma turma:professor.getTurmas()) {
                listaTurmas[i] = turma.getSigla() + ": " + turma.getTurma();
                i++;
            }
            jListTurmas.setListData(listaTurmas); 
        }
        else {
            String[] listaTurmas = {"Você não está lecionando nenhuma turma."};
            jListTurmas.setListData(listaTurmas); 
        }
    }
    
    private void jButtonCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCriarActionPerformed
        // TODO add your handling code here:
        JFrameCriarTurma frame = new JFrameCriarTurma(professor, this);
        frame.setVisible(true);
    }//GEN-LAST:event_jButtonCriarActionPerformed

    private void jListTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTurmasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && professor.getTurmas().size() != 0) {
            int index = jListTurmas.getSelectedIndex();
            Turma turma = professor.getTurmas().get(index);
            JFrameTurmaProfessor frameTurmaProfessor = new JFrameTurmaProfessor(frameMain, turma, professor);
            frameTurmaProfessor.setVisible(true);
            frameMain.setVisible(false); 
        }
    }//GEN-LAST:event_jListTurmasMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = jListTurmas.getSelectedIndex();
        professor.removeTurma(professor.getTurmas().get(index));
        this.criaListaTurmas();
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonCriar;
    private javax.swing.JList<String> jListTurmas;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private Professor professor; 
    private JFrameMain frameMain; 
}
