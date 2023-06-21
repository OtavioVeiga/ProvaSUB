package view;

import Conexão.Conexao;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.ValueEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class TelaCadastros extends javax.swing.JFrame {
     
    private void carregarDados() {
        Conexao conexao = new Conexao();
        DatabaseReference contatosRef = conexao.getDatabaseReference().child("Contato");

        contatosRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            DefaultTableModel model = (DefaultTableModel) Lista.getModel();
            model.setRowCount(0); 

            for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                
                String id = childSnapshot.getKey();
                String nome = childSnapshot.child("nome").getValue(String.class);
                String telefone = childSnapshot.child("telefone").getValue(String.class);

                
                model.addRow(new Object[]{id, nome, telefone});
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {
            
        }
    });
    }
    
    public TelaCadastros() {
        initComponents();
        buttonEditar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        int row = Lista.getSelectedRow();
        if (row >= 0) {
            String id = (String) Lista.getValueAt(row, 0);
            String nome = (String) Lista.getValueAt(row, 1);
            String telefone = (String) Lista.getValueAt(row, 2);

            // Abra a tela de edição passando os valores selecionados
            CadastroTelefone cadastro = new CadastroTelefone(id, nome, telefone);
            cadastro.setVisible(true);
        }
    }
});

        buttonRemove.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) {
        int row = Lista.getSelectedRow();
        if (row >= 0) {
            String id = (String) Lista.getValueAt(row, 0);

            // Remova o contato do Firebase Realtime Database
            Conexao conexao = new Conexao();
            DatabaseReference contatoRef = conexao.getDatabaseReference().child("Contato").child(id);
            contatoRef.removeValue(new CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        // Ocorreu um erro ao remover o contato
                        System.out.println("Erro ao remover o contato: " + databaseError.getMessage());
                    } else {
                        // O contato foi removido com sucesso
                        System.out.println("Contato removido com sucesso.");
                    }
                }
            });
        }
    }
});
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonNovo = new javax.swing.JButton();
        buttonEditar = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Lista = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonNovo.setText("NOVO");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        buttonEditar.setText("EDITAR");

        buttonRemove.setText("REMOVER");

        buttonSair.setText("SAIR");

        Lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(Lista);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar)
                    .addComponent(buttonRemove)
                    .addComponent(buttonSair))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        CadastroTelefone cadastro = new CadastroTelefone();
        
        cadastro.setVisible(true);
    }//GEN-LAST:event_buttonNovoActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Lista;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonSair;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
