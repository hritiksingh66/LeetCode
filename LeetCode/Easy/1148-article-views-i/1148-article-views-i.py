import pandas as pd

def article_views(views: pd.DataFrame) -> pd.DataFrame:
    unique_id = views[views['author_id'] == views['viewer_id']]['author_id'].unique()
    unique_id = sorted(unique_id)

    return pd.DataFrame({'id':unique_id})
