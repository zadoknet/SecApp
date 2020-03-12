package zadok.jct.SecApp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import zadok.jct.SecApp.Entities.Parcel;
import zadok.jct.SecApp.R;

public class RegisteredParcelAdapter  extends BaseAdapter {
    private Context context;
    private List<Parcel> parcelModelArrayList;

    public RegisteredParcelAdapter(Context context, List<Parcel> imageModelArrayList) {

        this.context = context;
        this.parcelModelArrayList = imageModelArrayList;

    }
    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }
    @Override
    public int getCount() {
        return parcelModelArrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return parcelModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {

        protected TextView tvname;
        private TextView mail;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.lv_item, null, true);

            holder.tvname = (TextView) convertView.findViewById(R.id.name);
            holder.mail = (TextView) convertView.findViewById(R.id.mailView);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tvname.setText(parcelModelArrayList.get(position).getName());
        holder.mail.setText(parcelModelArrayList.get(position).getMail());

        return convertView;
    }

}
