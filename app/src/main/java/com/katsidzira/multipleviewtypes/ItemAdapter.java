package com.katsidzira.multipleviewtypes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {

    List<Item> itemList;

    public ItemAdapter(List<Item> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view;

        if (i == 0) {
            view = layoutInflater.inflate(R.layout.item_one_list_view, viewGroup, false);
            return new ViewHolderOne(view);
        }
        view = layoutInflater.inflate(R.layout.item_two_list_view, viewGroup, false);
        return new ViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (itemList.get(i).getGender() == "male") {
            ViewHolderOne viewHolderOne = (ViewHolderOne) viewHolder;
            viewHolderOne.onBind(itemList.get(i));
        } else  {
            ViewHolderTwo viewHolderTwo = (ViewHolderTwo) viewHolder;
            viewHolderTwo.onBind(itemList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // CHECK FOR THE ITEM TYPE BASED ON A VALUE FROM THE MODEL

    @Override
    public int getItemViewType(int position) {

        if (itemList.get(position).getGender() == "male") {
            return 0;
        }
        return 1;
    }

    // TWO DIFFERENT VIEWHOLDERS

    class ViewHolderOne extends RecyclerView.ViewHolder {

        TextView nameText, descriptionText;

        public ViewHolderOne(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.item_one_name_text);
            descriptionText = itemView.findViewById(R.id.item_one_description_text);
        }

        public void onBind(Item item) {
            nameText.setText(item.getName());
            descriptionText.setText(item.getDescription());
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder {

        TextView nameText, descriptionText;

        public ViewHolderTwo(@NonNull View itemView) {
            super(itemView);

            nameText = itemView.findViewById(R.id.item_two_name_text);
            descriptionText = itemView.findViewById(R.id.item_two_description_text);
        }

        public void onBind(Item item) {
            nameText.setText(item.getName());
            descriptionText.setText(item.getDescription());
        }
    }

}
