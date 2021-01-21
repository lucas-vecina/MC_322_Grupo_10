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
public class JFrameAlunoProf extends javax.swing.JFrame {

    /**
     * Creates new form JFrameAlunoProf
     */
    public JFrameAlunoProf(Aluno aluno) {
        initComponents();
        this.aluno = aluno;
        criaInfo(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextAreaInfo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextAreaInfo.setEditable(false);
        jTextAreaInfo.setColumns(20);
        jTextAreaInfo.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jTextAreaInfo.setRows(5);
        jTextAreaInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("INFO"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextAreaInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextAreaInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    private void criaInfo() {
        String out = "Nome: " + aluno.getNome();
        out += "\n RA: " + aluno.getRa();
        out += "\n Matriculas: \n";
        for (Turma turma:aluno.getTurmas()) {
            out += turma.getSigla(); 
            if (aluno.getTurmas().indexOf(turma) != aluno.getTurmas().size() - 1) {
                out += ", "; 
            }
        }
        jTextAreaInfo.setText(out);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextAreaInfo;
    // End of variables declaration//GEN-END:variables
    private Aluno aluno; 
}
