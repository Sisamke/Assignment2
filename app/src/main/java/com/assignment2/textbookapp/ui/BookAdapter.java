package com.assignment2.textbookapp.ui;

import android.view.*;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.assignment2.textbookapp.R;
import com.assignment2.textbookapp.models.Textbook;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private List<Textbook> books;

    public BookAdapter(List<Textbook> books) {
        this.books = books;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleText, sellerText, priceText;

        public ViewHolder(View itemView) {
            super(itemView);
            titleText = itemView.findViewById(R.id.titleText);
            sellerText = itemView.findViewById(R.id.sellerText);
            priceText = itemView.findViewById(R.id.priceText);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Textbook book = books.get(position);

        holder.titleText.setText(book.getTitle());
        holder.sellerText.setText("Seller: " + book.getSeller());
        holder.priceText.setText("R" + book.getPrice());
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}