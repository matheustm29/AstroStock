package com.mycompany.astrostock;
import com.mycompany.astrostock.Tarefa;
import com.mycompany.astrostock.Membro;
import com.mycompany.astrostock.ControleMembros;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Cliente
 */
public class CadastroTarefa extends javax.swing.JFrame {

    /**
     * Creates new form CadastroTarefa
     */
    public CadastroTarefa() {
        initComponents();
        ControleMembros controle = ControleMembros.getInstancia();
        List<Membro> membros = controle.listarMembros();
        for (Membro membro : membros) {
            cbMembros.addItem(membro.getNome()); // O nome será mostrado, mas o objeto Membro é armazenado
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

        lblDescricao = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        txtStatus = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        cbMembros = new javax.swing.JComboBox<>();
        lblMembro = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        lblDescricao.setText("Descricao: ");

        lblStatus.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        lblStatus.setText("Status: ");

        txtDescricao.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        txtStatus.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        btnCadastrar.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        cbMembros.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

        lblMembro.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        lblMembro.setText("Membro Responsavel:");

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        jLabel1.setText("CADASTRO DE TAREFAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMembro)
                            .addComponent(lblStatus))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtStatus)
                            .addComponent(cbMembros, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnCadastrar)
                                .addGap(0, 94, Short.MAX_VALUE)))))
                .addGap(333, 333, 333))
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatus)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMembro)
                    .addComponent(cbMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addComponent(btnCadastrar)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        cadastrarTarefa();
    }//GEN-LAST:event_btnCadastrarActionPerformed
    private void cadastrarTarefa(){
        String descricao = txtDescricao.getText();
        String status = txtStatus.getText();
        //Funcao para pegar o ultimo id cadastrado
        int id = 1;
        ControleMembros controle = ControleMembros.getInstancia();
        List<Tarefa> tarefas = controle.listarTarefas();
        if(!tarefas.isEmpty()){
            Tarefa ultimaTarefa = tarefas.getLast();
            id = ultimaTarefa.getId() + 1;
        }
        //Funcao para pegar o id do membro selecionado
        int index = (int) cbMembros.getSelectedIndex();
        List<Membro> membros = controle.listarMembros();
        Membro membroSelecionado = membros.get(index);
        int idMembroResponsavel = membroSelecionado.getId();
        
        Tarefa novoTarefa = new Tarefa(id, descricao, status, idMembroResponsavel);
        Tarefa tarefaAdcionada = controle.adicionarTarefa(novoTarefa);
        if(tarefaAdcionada != null){
            JOptionPane.showMessageDialog(this, "Tarefa Cadastrada Com Sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroTarefa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cbMembros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblMembro;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
