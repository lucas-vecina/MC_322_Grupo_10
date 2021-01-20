/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FrontEnd;
import BackEnd.*; 
import java.util.HashMap;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections; 
/**
 *
 * @author guilh
 */
public class JPanelAluno extends javax.swing.JPanel {

    /**
     * Creates new form JPanelAluno
     */
    public JPanelAluno(Aluno aluno, JFrameMain frame) {
        initComponents();
        this.aluno = aluno; 
        this.frameMain = frame; 
        
        // Text field de informacao:
        criaTextInfo();
        
        // List de amigos
        criaListaAmigos();
        
        // List de Turmas
        criaRelacionadoTurma(); 
        
        // List de solicitacoes
        criaSolicitacoes(); 
        
        // List de feed
        criaFeed(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextInfo = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListFeed = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelAmigos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListAmigos = new javax.swing.JList<>();
        jPanelTurmas = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListTurmas = new javax.swing.JList<>();
        jPanelSolicitacoes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListSolicitacoes = new javax.swing.JList<>();
        jButtonExit = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(700, 521));

        jTable1.setFont(new java.awt.Font("Yu Gothic", 0, 10)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"08:00", null, null, null, null, null},
                {"09:00", "", null, null, null, null},
                {"10:00", "", null, null, null, null},
                {"11:00", null, null, null, null, null},
                {"14:00", null, null, null, null, null},
                {"15:00", null, null, null, null, null},
                {"16:00", null, null, null, null, null},
                {"17:00", null, null, null, null, null},
                {"20:00", null, null, null, null, null},
                {"21:00", null, null, null, null, null},
                {"22:00", null, null, null, null, null}
            },
            new String [] {
                "", "Segunda", "Terça", "Quarta", "Quinta", "Sexta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jTextInfo.setEditable(false);
        jTextInfo.setColumns(20);
        jTextInfo.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jTextInfo.setRows(5);
        jTextInfo.setToolTipText("");
        jTextInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Info de usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jScrollPane3.setViewportView(jTextInfo);

        jListFeed.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Feed", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic", 0, 11))); // NOI18N
        jListFeed.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListFeed.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não tem nada novo." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(jListFeed);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N

        jPanelAmigos.setBackground(new java.awt.Color(255, 255, 255));

        jListAmigos.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListAmigos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não tem amigos para exibir." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListAmigos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListAmigosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jListAmigos);

        javax.swing.GroupLayout jPanelAmigosLayout = new javax.swing.GroupLayout(jPanelAmigos);
        jPanelAmigos.setLayout(jPanelAmigosLayout);
        jPanelAmigosLayout.setHorizontalGroup(
            jPanelAmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );
        jPanelAmigosLayout.setVerticalGroup(
            jPanelAmigosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Amigos", jPanelAmigos);

        jPanelTurmas.setBackground(new java.awt.Color(255, 255, 255));

        jListTurmas.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListTurmas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não tem turmas para exibir." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListTurmas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListTurmasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListTurmas);

        javax.swing.GroupLayout jPanelTurmasLayout = new javax.swing.GroupLayout(jPanelTurmas);
        jPanelTurmas.setLayout(jPanelTurmasLayout);
        jPanelTurmasLayout.setHorizontalGroup(
            jPanelTurmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );
        jPanelTurmasLayout.setVerticalGroup(
            jPanelTurmasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Turmas", jPanelTurmas);

        jPanelSolicitacoes.setBackground(new java.awt.Color(255, 255, 255));

        jListSolicitacoes.setFont(new java.awt.Font("Yu Gothic", 0, 11)); // NOI18N
        jListSolicitacoes.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Você não tem solicitações pendentes." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListSolicitacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jListSolicitacoesMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(jListSolicitacoes);

        javax.swing.GroupLayout jPanelSolicitacoesLayout = new javax.swing.GroupLayout(jPanelSolicitacoes);
        jPanelSolicitacoes.setLayout(jPanelSolicitacoesLayout);
        jPanelSolicitacoesLayout.setHorizontalGroup(
            jPanelSolicitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );
        jPanelSolicitacoesLayout.setVerticalGroup(
            jPanelSolicitacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Solicitações", jPanelSolicitacoes);

        jButtonExit.setBackground(new java.awt.Color(201, 23, 48));
        jButtonExit.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.setText("Sair");
        jButtonExit.setBorder(null);
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Amigos");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents
   
    private void criaListaAmigos() {
        if (aluno.getAmigos().size() != 0) {
            String[] listaAmigos = new String[aluno.getAmigos().size()];
            int i = 0; 
            for(Usuario amigo:aluno.getAmigos()) {
                listaAmigos[i] = amigo.getNome(); 
                i++; 
            }
            jListAmigos.setListData(listaAmigos);
        }
    }
    
    private void criaRelacionadoTurma() {
        if (aluno.getTurmas().size() != 0) {
            String[] listaTurmas = new String[aluno.getTurmas().size()]; 
            int aux = 0;
            for(Turma turma:aluno.getTurmas()) {
                listaTurmas[aux] = turma.getSigla(); 
                aux++; 
                Set<Integer> chaves = turma.getHorarios().keySet(); 
                for (Integer chave:chaves) {
                    ArrayList<Integer> horarios = turma.getHorarios().get(chave);
                    for(Integer inteiro:horarios) {
                        boolean stop = false; 
                        for(int i = 0; i < 11 && !stop; i++) {
                            String value = (String)jTable1.getValueAt(i, 0);  
                            if (value.contains(Integer.toString(inteiro))) {
                                stop = true;
                                jTable1.setValueAt(turma.getSigla(), i, chave);
                            }
                        }
                    }
                }
            }
            jListTurmas.setListData(listaTurmas);
        }
    }
    
    private void criaTextInfo() { 
        String out = "Nome: " + aluno.getNome(); 
        out += "\nRA: " + aluno.getRa();
        out += "\nCurso: " + aluno.getCurso(); 
        out += "\nMatriculas:\n"; 
        for (Turma turma:aluno.getTurmas()) {
            out += turma.getSigla();
            if (aluno.getTurmas().indexOf(turma) != aluno.getTurmas().size()-1)
                out += ", "; 
        }
        jTextInfo.setText(out); 
    }
    
    private void criaSolicitacoes() {
        if (aluno.getSolicitacoes().size() != 0) {
            String[] listaSolicitacoes = new String[aluno.getSolicitacoes().size()];
            int i = 0;
            for (Solicitacao solicitacao:aluno.getSolicitacoes()) {
                listaSolicitacoes[i] = solicitacao.toString();
                i++; 
            }
            jListSolicitacoes.setListData(listaSolicitacoes); 
        }
    }
    
    private void criaFeed() {
        if (aluno.getFeedAluno().size() != 0) {
            String[] listaFeed = new String[aluno.getFeedAluno().size()];
            int i = 0; 
            for(Feed feed:aluno.getFeedAluno()) {
                listaFeed[i] = feed.exibirFeed(); 
                i++; 
            }
            jListFeed.setListData(listaFeed); 
        }
    }
    
    private void jListAmigosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListAmigosMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && aluno.getAmigos().size() != 0) {
            int index = jListAmigos.getSelectedIndex(); 
            Usuario amigo = aluno.getAmigos().get(index); 
            JFrameAmigo frameAmigo = new JFrameAmigo((Aluno)amigo); 
            frameAmigo.setVisible(true); 
        }
    }//GEN-LAST:event_jListAmigosMouseClicked

    private void jListTurmasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListTurmasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && aluno.getTurmas().size() != 0) {
            int index = jListTurmas.getSelectedIndex();
            Turma turma = aluno.getTurmas().get(index); 
            JFrameTurma frameTurma = new JFrameTurma(turma, aluno); 
            frameTurma.setVisible(true);
        }
    }//GEN-LAST:event_jListTurmasMouseClicked

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
        JFrameExit exit = new JFrameExit(frameMain);
        exit.setVisible(true); 
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jListSolicitacoesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListSolicitacoesMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && aluno.getSolicitacoes().size() != 0) { 
            int index = jListSolicitacoes.getSelectedIndex(); 
            Solicitacao solicitacao = aluno.getSolicitacoes().get(index); 
            JFrameSolicitacao frameSolicitacao = new JFrameSolicitacao(this, frameMain, solicitacao, aluno);
            frameSolicitacao.setVisible(true); 
        }
    }//GEN-LAST:event_jListSolicitacoesMousePressed

    public javax.swing.JPanel getJPanelAmigos() {
        return jPanelAmigos;
    }
    
    public javax.swing.JPanel getJPanelSolicitacoes() {
        return jPanelSolicitacoes; 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExit;
    private javax.swing.JList<String> jListAmigos;
    private javax.swing.JList<String> jListFeed;
    private javax.swing.JList<String> jListSolicitacoes;
    private javax.swing.JList<String> jListTurmas;
    private javax.swing.JPanel jPanelAmigos;
    private javax.swing.JPanel jPanelSolicitacoes;
    private javax.swing.JPanel jPanelTurmas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextInfo;
    // End of variables declaration//GEN-END:variables
    private Aluno aluno; 
    private JFrameMain frameMain; 
}
