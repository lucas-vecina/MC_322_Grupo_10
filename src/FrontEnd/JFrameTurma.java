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
public class JFrameTurma extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTurma
     */
    public JFrameTurma(JFrameMain frameMain, Turma turma, Aluno aluno) {
        initComponents();
        setTitle(turma.getSigla());
        this.turma = turma;
        this.aluno = aluno; 
        this.frameMain = frameMain;
        String out = "Nome: " + turma.getTurma();
        out += "\nSigla: " + turma.getSigla();
        out += "\nProfessor: " + turma.getProfessor().getNome(); 
        jTextPaneInfo.setText(out); 
        criaListaAlunos();
        criaListaDuvidas(); 
        criaListaMonitorias(); 
        if(!turma.getPed().contains(aluno)) {
            jMenuPed.setVisible(false);
        }
        
        if(!turma.getPad().contains(aluno)) {
            jMenuPad.setVisible(false); 
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneInfo = new javax.swing.JTextArea();
        jButtonEmenta = new javax.swing.JButton();
        jTextFieldDuvida = new javax.swing.JTextField();
        jButtonDuvida = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListAlunos = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListDuvidas = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListMonitoria = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuGeral = new javax.swing.JMenu();
        jMenuPed = new javax.swing.JMenu();
        jMenuItemMonitoriaPed = new javax.swing.JMenuItem();
        jMenuItemAtividade = new javax.swing.JMenuItem();
        jMenuPad = new javax.swing.JMenu();
        jMenuItemMonitoriaPad = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextPaneInfo.setEditable(false);
        jTextPaneInfo.setColumns(20);
        jTextPaneInfo.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jTextPaneInfo.setRows(5);
        jTextPaneInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações gerais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jScrollPane1.setViewportView(jTextPaneInfo);

        jButtonEmenta.setBackground(new java.awt.Color(201, 23, 48));
        jButtonEmenta.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonEmenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEmenta.setText("Ver ementa");
        jButtonEmenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonEmenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEmentaActionPerformed(evt);
            }
        });

        jTextFieldDuvida.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N

        jButtonDuvida.setBackground(new java.awt.Color(201, 23, 48));
        jButtonDuvida.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonDuvida.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDuvida.setText("Criar Duvida");
        jButtonDuvida.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonDuvida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDuvidaActionPerformed(evt);
            }
        });

        jButtonVoltar.setBackground(new java.awt.Color(201, 23, 48));
        jButtonVoltar.setFont(new java.awt.Font("Yu Gothic", 1, 11)); // NOI18N
        jButtonVoltar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVoltar.setText("Voltar");
        jButtonVoltar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jListAlunos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alunos na turma", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListAlunos.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListAlunos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Não há pessoas nessa turma." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAlunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAlunosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jListAlunos);

        jListDuvidas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dúvidas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListDuvidas.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListDuvidas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Não há dúvidas nessa turma." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListDuvidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListDuvidasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListDuvidas);

        jListMonitoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monitorias abertas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListMonitoria.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListMonitoria.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Nao ha monitorias abertas no momento." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListMonitoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListMonitoriaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jListMonitoria);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEmenta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jTextFieldDuvida, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addGap(109, 109, 109))
                        .addComponent(jButtonDuvida, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldDuvida, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonEmenta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonDuvida, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addComponent(jButtonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(162, 162, 162)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jMenuGeral.setText("Geral");
        jMenuGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuGeralMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuGeral);

        jMenuPed.setText("PED");

        jMenuItemMonitoriaPed.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItemMonitoriaPed.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jMenuItemMonitoriaPed.setText("Monitoria");
        jMenuItemMonitoriaPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMonitoriaPedActionPerformed(evt);
            }
        });
        jMenuPed.add(jMenuItemMonitoriaPed);

        jMenuItemAtividade.setText("Atividade");
        jMenuPed.add(jMenuItemAtividade);

        jMenuBar1.add(jMenuPed);

        jMenuPad.setText("PAD");

        jMenuItemMonitoriaPad.setText("Monitoria");
        jMenuItemMonitoriaPad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMonitoriaPadActionPerformed(evt);
            }
        });
        jMenuPad.add(jMenuItemMonitoriaPad);

        jMenuBar1.add(jMenuPad);

        setJMenuBar(jMenuBar1);

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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void criaListaAlunos() {
        if(turma.getAlunos().size() != 0) {
            String[] listaAlunos = new String[turma.getAlunos().size()]; 
            int i = 0; 
            for(Aluno aluno:turma.getAlunos()) {
                listaAlunos[i] = aluno.getNome() + ", RA: " + aluno.getRa(); 
                i++; 
            }
            jListAlunos.setListData(listaAlunos);
        }
    }
    
    private void criaListaDuvidas() {
        if(turma.getDuvidas().size() != 0) {
            String[] listaDuvidas = new String[turma.getDuvidas().size()];
            int i = 0; 
            for(Duvidas duvida:turma.getDuvidas()) {
                listaDuvidas[i] = "Duvida de " + duvida.getIndagador().getNome(); 
                i++; 
            }
            jListDuvidas.setListData(listaDuvidas); 
        }
    }
    
    private void criaListaMonitorias() {
        ArrayList<Monitoria> aux = new ArrayList<Monitoria>();
        for(Monitoria monitoria:turma.getMonitorias()) {
            if(monitoria.isStatus() && !monitoria.getMonitor().equals(aluno)) {
                aux.add(monitoria); 
            }
        }
        if(aux.size() != 0) {
            String[] listaMonitorias = new String[aux.size()]; 
            int i = 0;
            for(Monitoria monitoria:aux) {
                if (monitoria.isStatus() && !monitoria.getMonitor().equals(aluno))
                    listaMonitorias[i] = "Monitoria de " + monitoria.getMonitor().getNome() + " está aberta."; 
            }
            jListMonitoria.setListData(listaMonitorias);
        }
    }
    
    private void jButtonEmentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEmentaActionPerformed
        // TODO add your handling code here:
        JFrameEmenta frameEmenta = new JFrameEmenta(turma);
        frameEmenta.setVisible(true);
    }//GEN-LAST:event_jButtonEmentaActionPerformed

    private void jButtonDuvidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDuvidaActionPerformed
        // TODO add your handling code here:
        if(!jTextFieldDuvida.getText().equals("")) {
            String out = jTextFieldDuvida.getText();
            jTextFieldDuvida.setText("");
            turma.criarDuvida(aluno, out);
            criaListaDuvidas();
            this.revalidate();
            this.repaint();
        }
    }//GEN-LAST:event_jButtonDuvidaActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        JPanelAluno panel = new JPanelAluno(aluno, frameMain);
        frameMain.setContentPane(panel);
        frameMain.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jListAlunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAlunosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && turma.getAlunos().size() != 0) {
            int index = jListAlunos.getSelectedIndex();
            Usuario amigo = turma.getAlunos().get(index);
            JFrameAmigo frameAmigo = new JFrameAmigo(aluno, (Aluno)amigo);
            frameAmigo.setVisible(true);
        }
    }//GEN-LAST:event_jListAlunosMouseClicked

    private void jListDuvidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListDuvidasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && turma.getDuvidas().size() != 0) {
            int index = jListDuvidas.getSelectedIndex();
            Duvidas duvida = turma.getDuvidas().get(index);
            JFrameDuvida frameDuvida = new JFrameDuvida(duvida, aluno);
            frameDuvida.setVisible(true);
        }
    }//GEN-LAST:event_jListDuvidasMouseClicked

    private void jMenuItemMonitoriaPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMonitoriaPedActionPerformed
        // TODO add your handling code here:
        Monitoria monitoriaAluno = null;
        for(Monitoria monitoria:turma.getMonitorias()) {
            if(monitoria.getMonitor().equals(aluno)) {
                monitoriaAluno = monitoria; 
            }
        }
        JPanelMonitor panel = new JPanelMonitor(monitoriaAluno); 
        setContentPane(panel); 
        panel.revalidate();
        panel.repaint(); 
    }//GEN-LAST:event_jMenuItemMonitoriaPedActionPerformed

    private void jMenuItemMonitoriaPadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMonitoriaPadActionPerformed
        // TODO add your handling code here:
        Monitoria monitoriaAluno = null;
        for(Monitoria monitoria:turma.getMonitorias()) {
            if(monitoria.getMonitor().equals(aluno)) {
                monitoriaAluno = monitoria; 
            }
        }
        JPanelMonitor panel = new JPanelMonitor(monitoriaAluno); 
        setContentPane(panel); 
        panel.revalidate();
        panel.repaint(); 
    }//GEN-LAST:event_jMenuItemMonitoriaPadActionPerformed

    private void jMenuGeralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuGeralMouseClicked
        // TODO add your handling code here:
        if(!getContentPane().equals(jPanel1)) {
            criaListaAlunos();
            criaListaDuvidas(); 
            criaListaMonitorias();
            jPanel1.revalidate();
            jPanel1.repaint();
            setContentPane(jPanel1); 
        }
    }//GEN-LAST:event_jMenuGeralMouseClicked

    private void jListMonitoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListMonitoriaMouseClicked
        // TODO add your handling code here:
        ArrayList<Monitoria> aux = new ArrayList<Monitoria>();
        for(Monitoria monitoria:turma.getMonitorias()) {
            if(monitoria.isStatus() && !monitoria.getMonitor().equals(aluno)) {
                aux.add(monitoria); 
            }
        }
        if(evt.getClickCount() == 2 && aux.size() != 0) {
            int index = jListMonitoria.getSelectedIndex(); 
            Monitoria monitoria = aux.get(index); 
            JFrameMonitoriaAluno frameMonitoriaAluno = new JFrameMonitoriaAluno(monitoria, aluno);
            frameMonitoriaAluno.setVisible(true); 
        }
    }//GEN-LAST:event_jListMonitoriaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDuvida;
    private javax.swing.JButton jButtonEmenta;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JList<String> jListAlunos;
    private javax.swing.JList<String> jListDuvidas;
    private javax.swing.JList<String> jListMonitoria;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuGeral;
    private javax.swing.JMenuItem jMenuItemAtividade;
    private javax.swing.JMenuItem jMenuItemMonitoriaPad;
    private javax.swing.JMenuItem jMenuItemMonitoriaPed;
    private javax.swing.JMenu jMenuPad;
    private javax.swing.JMenu jMenuPed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextFieldDuvida;
    private javax.swing.JTextArea jTextPaneInfo;
    // End of variables declaration//GEN-END:variables
    private Turma turma;
    private Aluno aluno;
    private JFrameMain frameMain;
}
