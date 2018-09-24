package devicecosmos.com.categoreis;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UploadAdapter extends RecyclerView.Adapter<UploadAdapter.ImageViewHolder>{


    private Context mContext;
    private List<BlogDownload> mUploads;

    public UploadAdapter(Context mContext, List<BlogDownload> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.show_item,parent,false);
        ImageViewHolder evh = new ImageViewHolder(v,mListener);
        return evh;

    }

    @Override
    public void onBindViewHolder(@NonNull UploadAdapter.ImageViewHolder holder, int position) {
            BlogDownload blog=mUploads.get(position);

        holder.tvTitle.setText(blog.getTitle());
        holder.tvDate.setText(blog.getDate());
        holder.tvDetails.setText(blog.getDetails());
        holder.tvLink.setText("Read more...");
        holder.tvYoutube.setText("see on Youtube");
        holder.tvTime.setText(blog.getTime());
        Picasso.with(mContext).load(blog.getImageURL())
                .placeholder(R.mipmap.ic_launcher).fit()
                .centerCrop().into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    private OnItemClickListener mListener;
    public interface OnItemClickListener
    {
        void onReadClicked(int position);
        void onYoutubeClicked(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        mListener=listener;
    }

    public static class ImageViewHolder extends RecyclerView.ViewHolder{

        public TextView tvTitle,tvDate,tvTime,tvLink,tvDetails,tvYoutube;
        public ImageView imageView;



        public ImageViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            tvTitle=itemView.findViewById(R.id.textViewTitle);
            tvDate=itemView.findViewById(R.id.textViewDate);
            tvLink=itemView.findViewById(R.id.text_view_status);
            imageView=itemView.findViewById(R.id.image_view_upload);
            tvDetails=itemView.findViewById(R.id.textViewDetails);
            tvTime=itemView.findViewById(R.id.textViewTime);
            tvYoutube=itemView.findViewById(R.id.text_view_youtube);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION)
                        {
                            listener.onReadClicked(position);
                        }
                    }
                }
            });
            tvYoutube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION)
                        {
                            listener.onYoutubeClicked(position);
                        }
                    }
                }
            });

            tvLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null)
                    {
                        int position=getAdapterPosition();
                        if (position!= RecyclerView.NO_POSITION)
                        {
                            listener.onReadClicked(position);
                        }
                    }
                }
            });
        }
    }
}
