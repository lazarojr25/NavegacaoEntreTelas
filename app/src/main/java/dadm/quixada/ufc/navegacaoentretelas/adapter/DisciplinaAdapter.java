package dadm.quixada.ufc.navegacaoentretelas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dadm.quixada.ufc.navegacaoentretelas.R;
import dadm.quixada.ufc.navegacaoentretelas.model.Disciplina;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {
    private ArrayList<Disciplina> localDataSet;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    public DisciplinaAdapter(ArrayList<Disciplina> dataSet){
        this.localDataSet = dataSet;
    }

    public DisciplinaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 0;
    }


}
