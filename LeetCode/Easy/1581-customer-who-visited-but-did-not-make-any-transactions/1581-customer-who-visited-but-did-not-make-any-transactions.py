import pandas as pd

def find_customers(visits: pd.DataFrame, transactions: pd.DataFrame) -> pd.DataFrame:
    not_visited = pd.merge(left=visits,right=transactions,on="visit_id",how="left")
    not_visited = not_visited[not_visited["transaction_id"].isna()]
    not_visited = not_visited.groupby("customer_id",as_index=False).agg(count_no_trans=("customer_id","count"))
    
    print(not_visited)
    return not_visited