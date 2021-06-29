
package nastya.shymanovich.casher.ui.fragments.operations.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nastya.shymanovich.casher.R
import nastya.shymanovich.casher.databinding.OperationItemBinding
import nastya.shymanovich.casher.domain.db.entity.CashOperation

class OperationAdapter : RecyclerView.Adapter<OperationAdapter.ViewHolder>() {

    private val arrayList = arrayListOf<CashOperation>()

    fun setData(list: List<CashOperation>) {
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.operation_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemView = holder.itemView
        val element = arrayList[position]

        holder.bind(element)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binder = OperationItemBinding.bind(view)
        private val context = binder.root.context
        private val date = binder.dateTv
        private val monthOfYear = binder.monthOfYear
        private val dayOfWeakly = binder.dayOfWeakly
        private val recyclerView = binder.recyclerView

        fun bind(cashEntity: CashOperation) {

        }
    }
}