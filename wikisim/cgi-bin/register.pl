#!"C:\xampp\perl\bin\perl.exe"
use strict;
use warnings;
use CGI;
use CGI::Carp qw(fatalsToBrowser);
use DBI;

my $cgi = CGI->new;
print $cgi->header;

my $username = $cgi->param('username');
my $password = $cgi->param('password');

my $dbh = DBI->connect("DBI:mysql:database=BaseDeDatos;host=localhost", "admin", "admin", {RaiseError => 1, PrintError => 0});
my $sth = $dbh->prepare("INSERT INTO Users (username, password) VALUES (?, ?)");
$sth->execute($username, $password);

print $cgi->redirect('../cgi-bin/login.pl');

$dbh->disconnect;