package com.example.finalproject_petshop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.finalproject_petshop.R;
import com.example.finalproject_petshop.models.HomeItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<HomeItem> itemList;

    public HomeAdapter(List<HomeItem> itemList) {
        this.itemList = itemList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCliente, txtPet, txtQtdServicos, txtUltimoServico;

        public ViewHolder(View itemView) {
            super(itemView);
            txtCliente = itemView.findViewById(R.id.txtCliente);
            txtPet = itemView.findViewById(R.id.txtPet);
            txtQtdServicos = itemView.findViewById(R.id.txtQtdServicos);
            txtUltimoServico = itemView.findViewById(R.id.txtUltimoServico);
        }
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {
        HomeItem item = itemList.get(position);
        holder.txtCliente.setText(item.getClienteNome());
        holder.txtPet.setText(item.getPetNome());
        holder.txtQtdServicos.setText(String.valueOf(item.getQtdServicos()));
        holder.txtUltimoServico.setText(item.getUltimoServico());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
