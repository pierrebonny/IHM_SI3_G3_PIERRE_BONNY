package polytechnice.tobeortohave.main;

/**
 * Created by Pierre on 12/05/2017.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import polytechnice.tobeortohave.Article;
import polytechnice.tobeortohave.R;

public class CarouselAdapter extends BaseAdapter {

    private ArrayList<Article> data;
    private CarouselFragment fragment;

    public CarouselAdapter(CarouselFragment context, ArrayList<Article> objects) {
        this.fragment = context;
        this.data = objects;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Article getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) fragment.getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_view, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.articleImage.setImageResource(data.get(position).getImageSource());
        viewHolder.articleName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(fragment.getActivity());
                dialog.setContentView(R.layout.dialog);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle("Article Details");

                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(getItem(position).getName());
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(getItem(position).getImageSource());

                dialog.show();
            }
        };
    }


    private static class ViewHolder {
        private TextView articleName;
        private ImageView articleImage;

        public ViewHolder(View v) {
            articleImage = (ImageView) v.findViewById(R.id.image);
            articleName = (TextView) v.findViewById(R.id.name);
            articleName.setTextColor(Color.parseColor("#000000"));
        }
    }
}
