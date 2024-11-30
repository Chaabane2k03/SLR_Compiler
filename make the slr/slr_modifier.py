import csv

def process_csv(file_path):
    # Open the CSV file
    with open(file_path, 'r') as csv_file:
        reader = csv.reader(csv_file)  # Read the CSV file
        processed_lines = []
        
        for row in reader:
            # Process each row: wrap each value in "" and join with commas
            formatted_values = ['"' + value + '"' for value in row]
            # Wrap the entire line in {}
            formatted_line = "{" + ", ".join(formatted_values) + "}"
            processed_lines.append(formatted_line)
    
    # Join all processed lines with newlines
    return ",\n".join(processed_lines)

# Example usage
file_path = "./slr.csv"  # Replace with the path to your CSV file
output = process_csv(file_path)
print(output)