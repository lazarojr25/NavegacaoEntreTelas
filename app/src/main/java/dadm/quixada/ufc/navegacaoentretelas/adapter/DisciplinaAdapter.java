package dadm.quixada.ufc.navegacaoentretelas.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dadm.quixada.ufc.navegacaoentretelas.R;
import dadm.quixada.ufc.navegacaoentretelas.model.Disciplina;

public class DisciplinaAdapter extends RecyclerView.Adapter<DisciplinaAdapter.ViewHolder> {


    private List<Disciplina> localDataSet;
    private Activity activit;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */

    public Context getContext()
    {
        return activit;
    }

    public void deleteItem(int position)
    {
        //Tarefa item = localDataSet.get(position);
        localDataSet.remove(position);
        notifyItemRemoved(position);
    }


    public void editItem(int position)
    {
        Disciplina item = localDataSet.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView nomeDisciplina;
        private TextView idDisciplina;
        private TextView codigoDisciplina;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            nomeDisciplina =view.findViewById(R.id.txtvNome);
            idDisciplina = view.findViewById(R.id.txtvId);
            codigoDisciplina = view.findViewById(R.id.txtCodigo);


        }

        public CheckBox getCheckBox() {
            return null;
        }


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public DisciplinaAdapter( ArrayList<Disciplina> dataSet) {
        localDataSet = dataSet;
    }
    public DisciplinaAdapter(Activity mainActivity) {

        this.activit = mainActivity;
    }

    public void setTasks(List<Disciplina> toDoList)
    {
        this.localDataSet = toDoList;
        notifyDataSetChanged();
    }
    // Create new views (invoked by the layout manager)
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.diciplina_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        Disciplina item = localDataSet.get(position);
        viewHolder.idDisciplina.setText(String.valueOf(item.getId()));
        viewHolder.nomeDisciplina.setText(item.getNome().toString());
        viewHolder.codigoDisciplina.setText(item.getCodigo().toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return localDataSet.size();
    }


}
