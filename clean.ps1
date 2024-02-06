# Define the directory to start the search
$directoryToSearch = "."

# Remove .class files recursively
Get-ChildItem -Path $directoryToSearch -Recurse -Filter "*.class" | Remove-Item -Force
